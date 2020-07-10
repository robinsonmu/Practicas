package com.prodigious.deliverySystem.io;

import com.prodigious.deliverySystem.base.Command;
import com.prodigious.deliverySystem.drons.Dron;
import com.prodigious.deliverySystem.drons.utils.CardinalPoint;

import java.util.Optional;
import java.util.stream.Stream;

public enum DeliveryTask {

    MOVE_FORWARD("F", n->n.move(CardinalPoint.NORTH)),
    MOVE_BACKWARD("B",  n->n.move(CardinalPoint.SOUTH)),
    MOVE_WEST("W", n->n.move(CardinalPoint.WEST)),
    MOVE_EAST("E", n->n.move(CardinalPoint.EAST));

    private String id;
    private Command<Dron> command;

    private DeliveryTask(String id, Command<Dron> command){
        this.id=id;
        this.command=command;
    }

    public Command<Dron> getCommand(){
        return command;
    }

    public static Optional<DeliveryTask> fromString(String taskId){
        return Stream.of(DeliveryTask.values()).filter(t->t.id.equals(taskId)).findFirst();
    }
}
