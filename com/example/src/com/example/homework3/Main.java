package com.example.homework3;

public class Main {

    public static void main(String[] args) {
       Ball ball = new Ball((float)0.1,(float)5,1,10,0);
       Container container=new Container(0,0,30,15);
       System.out.println(ball.toString());
       System.out.println("Ball in the container?: "+container.collides(ball));
       ball.move();
       ball.setxDelta(5);
       ball.move();
       System.out.println(ball.toString());
       System.out.println("Ball in the container?: "+container.collides(ball));
       ball.setyDelta(3);
       ball.move();
       ball.setxDelta(10);
       ball.setyDelta(6);
       ball.move();
       System.out.println(ball.toString());
       System.out.println("Ball in the container?: "+container.collides(ball));
    }
}
