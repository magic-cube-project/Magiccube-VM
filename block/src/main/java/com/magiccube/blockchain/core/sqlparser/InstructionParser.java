package com.magiccube.blockchain.core.sqlparser;

import com.magiccube.blockchain.block.InstructionBase;

public interface InstructionParser {
    boolean parse(InstructionBase instructionBase);
}
