package com.bortbort.arduino.FiloFirmata.Parser;

import com.bortbort.arduino.FiloFirmata.Listeners.MessageListener;
import com.bortbort.arduino.FiloFirmata.Messages.Message;

import java.io.InputStream;

/**
 * Created by chuck on 1/5/2016.
 */
public abstract class MessageParser {
    private byte commandByte;

    public MessageParser(byte commandByte) {
        this.commandByte = commandByte;
    }

    public MessageParser(CommandBytes commandByte) {
        this.commandByte = commandByte.getCommandByte();
    }

    public byte getCommandByte() {
        return commandByte;
    }

    public abstract Message buildMessage(InputStream inputStream);

}
