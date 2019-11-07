package com.example.src.com.example;

public class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    MyComplex(){}

    MyComplex(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString(){
        return "("+real+"+"+imag+"i)";
    }

    public boolean isReal(){
        boolean real = true;
        if (this.real == 0){
            real = false;
        }
        return real;
    }

    public boolean isImaginary(){
        boolean imag = true;
        if (this.imag == 0){
            imag = false;
        }
        return imag;
    }

    public boolean equals(double real, double imag){
        boolean var = false;
        if ((this.real == real)&&(this.imag == imag)){
            var = true;
        }
        return var;
    }

    public boolean equals(MyComplex another){
        boolean var = false;
        if ((this.real==another.real)&&(this.imag==another.imag)){
            var = true;
        }
        return var;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public double argument(){
        return Math.atan2(this.imag, this.real);
    }

    public MyComplex add (MyComplex right){
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew (MyComplex right){
        MyComplex myComplex = new MyComplex();
        myComplex.real += this.real+right.real;
        myComplex.imag += this.imag+right.imag;
        return myComplex;
    }

    public MyComplex substract (MyComplex right){
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex substractNew (MyComplex right){
        MyComplex myComplex = new MyComplex();
        myComplex.real = this.real - right.real;
        myComplex.imag = this.imag - right.imag;
        return myComplex;
    }

    public MyComplex multiply (MyComplex right){
        double r=this.real;
        double i=this.imag;
        this.real = r*right.real-i*right.imag;
        this.imag = r*right.imag+i*right.real;
        return this;
    }

    public MyComplex divide (MyComplex right){
        double r=this.real;
        double i=this.imag;
        this.real = (r*right.real+i*right.imag)/(Math.pow(right.real,2)+Math.pow(right.imag,2));
        this.imag = (i*right.real-r*right.imag)/(Math.pow(right.real,2)+Math.pow(right.imag,2));
        return this;
    }

    public MyComplex conjugate (){
        return new MyComplex(this.real, (-1)* this.imag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyComplex)){return false;}

        MyComplex myComplex = (MyComplex) o;

        return (myComplex.real == this.real)&&
                (myComplex.imag==this.imag);
    }

    @Override
    public int hashCode() {
        int result=17;
        result = 31*result + (int)this.real;
        result = 31*result + (int)this.imag;
        return result;
    }
}
