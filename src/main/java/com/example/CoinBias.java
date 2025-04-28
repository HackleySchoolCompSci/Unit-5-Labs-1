package com.example;

public class CoinBias
{
    private static final int HEADS = 0;
    private static final int TAILS = 1;
    private int face;
    private double bias;

    public CoinBias ()
    {
	bias = 0.5;
	flip();
    }

    public CoinBias (double bias)
    {
	//Set given bias if it's in range, else make coin fair
	if (bias >=0 && bias < 1)
	    this.bias = bias;
	else
	    this.bias = 0.5;

	flip();
    }

    public void flip()
    {
	if (Math.random() < bias)
	    face = HEADS;
	else
	    face = TAILS;
    }

    public boolean isHeads()
    {
	    return (face == HEADS);
    }

    public double getBias()
    {
        return bias;
    }
    
    public String toString()
    {
	String faceName;

	if (face == HEADS)
	    faceName = "Heads";
	else
	    faceName = "Tails";

	return faceName;
    }
}

