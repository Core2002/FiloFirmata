package com.bortbort.arduino.FiloFirmata.Parser.Builders;

import com.bortbort.arduino.FiloFirmata.Messages.Message;
import com.bortbort.arduino.FiloFirmata.PinCapability;
import com.bortbort.arduino.FiloFirmata.Messages.SysexPinStateMessage;
import com.bortbort.arduino.FiloFirmata.Parser.SysexCommandBytes;
import com.bortbort.arduino.FiloFirmata.Parser.SysexMessageBuilder;

/**
 * Created by chuck on 1/14/2016.
 */
public class SysexPinStateResponseBuilder extends SysexMessageBuilder {

    public SysexPinStateResponseBuilder() {
        super(SysexCommandBytes.PIN_STATE_RESPONSE);
    }

    @Override
    public Message buildMessage(byte[] messageBody) {
        Integer pinIdentifier = (int) messageBody[0];
        PinCapability currentPinMode = PinCapability.getCapability(messageBody[1]);
        int value = 0;
        for (int x = 2; x < messageBody.length; x++) {
            value |= messageBody[x] << ((x - 2) * 7);
        }

        return new SysexPinStateMessage(pinIdentifier, currentPinMode, value);
    }

}
