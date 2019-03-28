package com.magiccube.blockchain.core.service;

import com.magiccube.blockchain.block.PairKey;
import com.magiccube.blockchain.common.TrustSDK;
import com.magiccube.blockchain.common.exception.TrustSDKException;
import org.springframework.stereotype.Service;

@Service
public class PairKeyService {

    /**
     * 生成公私钥对
     * @return PairKey
     * @throws TrustSDKException TrustSDKException
     */
    public PairKey generate() throws TrustSDKException {
        return TrustSDK.generatePairKey(true);
    }
}
