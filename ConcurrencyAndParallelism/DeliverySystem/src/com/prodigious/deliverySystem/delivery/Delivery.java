package com.prodigious.deliverySystem.delivery;

import com.prodigious.deliverySystem.base.Command;
import com.prodigious.deliverySystem.base.Script;
import com.prodigious.deliverySystem.drons.Dron;

import java.util.ArrayList;
import java.util.List;

public class Delivery implements Script<Dron> {

    List<Command<Dron>> commands=new ArrayList<>();

    @Override
    public void addCommand(Command<Dron> command) {
        commands.add(command);
    }

    @Override
    public void execute(Dron dron) {
        throw new UnsupportedOperationException();
    }

}
