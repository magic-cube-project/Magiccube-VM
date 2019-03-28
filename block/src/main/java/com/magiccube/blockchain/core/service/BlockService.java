package com.magiccube.blockchain.core.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.magiccube.blockchain.block.Block;
import com.magiccube.blockchain.block.BlockHeader;
import com.magiccube.blockchain.block.Instruction;
import com.magiccube.blockchain.block.merkle.MerkleTree;
import com.magiccube.blockchain.common.CommonUtil;
import com.magiccube.blockchain.common.Sha256;
import com.magiccube.blockchain.common.exception.TrustSDKException;
import com.magiccube.blockchain.core.manager.DbBlockManager;
import com.magiccube.blockchain.core.manager.PermissionManager;
import com.magiccube.blockchain.core.requestbody.BlockRequestBody;
import com.magiccube.blockchain.socket.body.RpcBlockBody;
import com.magiccube.blockchain.socket.client.PacketSender;
import com.magiccube.blockchain.socket.packet.BlockPacket;
import com.magiccube.blockchain.socket.packet.PacketBuilder;
import com.magiccube.blockchain.socket.packet.PacketType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlockService {
    @Resource
    private InstructionService instructionService;
    @Value("${version}")
    private int version;
    @Resource
    private PacketSender packetSender;
    @Resource
    private DbBlockManager dbBlockManager;
    @Resource
    private PermissionManager permissionManager;

    /**
     * 校验指令集是否合法
     *
     * @param blockRequestBody
     *         指令集
     * @return 是否合法，为null则校验通过，其他则失败并返回原因
     */
    public String check(BlockRequestBody blockRequestBody) throws TrustSDKException {
        //TODO 此处可能需要校验publicKey的合法性
        if (blockRequestBody == null || blockRequestBody.getBlockBody() == null || StrUtil.isEmpty(blockRequestBody
                .getPublicKey())) {
            return "请求参数缺失";
        }
        List<Instruction> instructions = blockRequestBody.getBlockBody().getInstructions();
        if (CollectionUtil.isEmpty(instructions)) {
            return "指令信息不能为空";
        }

        for (Instruction instruction : instructions) {
            if (!StrUtil.equals(blockRequestBody.getPublicKey(), instruction.getPublicKey())) {
                return "指令内公钥和传来的公钥不匹配";
            }
            if (!instructionService.checkSign(instruction)) {
                return "签名校验不通过";
            }
            if (!instructionService.checkHash(instruction)) {
                return "Hash校验不通过";
            }
        }

        if (!permissionManager.checkPermission(instructions)) {
            return "权限校验不通过";
        }

        return null;
    }

    /**
     * 添加新的区块
     * @param blockRequestBody blockRequestBody
     * @return Block
     */
    public Block addBlock(BlockRequestBody blockRequestBody) {
        com.magiccube.blockchain.block.BlockBody blockBody = blockRequestBody.getBlockBody();
        List<Instruction> instructions = blockBody.getInstructions();
        List<String> hashList = instructions.stream().map(Instruction::getHash).collect(Collectors
                .toList());

        BlockHeader blockHeader = new BlockHeader();
        blockHeader.setHashList(hashList);

        //计算所有指令的hashRoot
        blockHeader.setHashMerkleRoot(new MerkleTree(hashList).build().getRoot());
        blockHeader.setPublicKey(blockRequestBody.getPublicKey());
        blockHeader.setTimeStamp(CommonUtil.getNow());
        blockHeader.setVersion(version);
        blockHeader.setNumber(dbBlockManager.getLastBlockNumber() + 1);
        blockHeader.setHashPreviousBlock(dbBlockManager.getLastBlockHash());
        Block block = new Block();
        block.setBlockBody(blockBody);
        block.setBlockHeader(blockHeader);
        block.setHash(Sha256.sha256(blockHeader.toString() + blockBody.toString()));

        BlockPacket blockPacket = new PacketBuilder<>().setType(PacketType.GENERATE_BLOCK_REQUEST).setBody(new
                RpcBlockBody(block)).build();

        //广播给其他人做验证
        packetSender.sendGroup(blockPacket);

        return block;
    }

}
