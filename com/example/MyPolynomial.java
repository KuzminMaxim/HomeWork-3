package com.example.src.com.example;

import java.util.Arrays;

public class MyPolynomial {

    private double[] coeffs;

    MyPolynomial(double...coeffs){
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return (this.coeffs.length-1);
    }

    @Override
    public String toString(){
        String result="";
        for (int i=getDegree();i>=0;i--){
            if (i!=0) {
                result += this.coeffs[i]+"*x^"+i+"+";
            }
            else result += this.coeffs[i];
        }
        return result;
    }

    public double evaluate(double x){
        int result = 0;
        for (int i=0;i<(this.coeffs.length);i++){
            result += this.coeffs[i]*Math.pow(x,i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right){
        int m = this.coeffs.length;
        int n = right.coeffs.length;
        if (m>=n){
            double[] newCoeffs=new double[m];

            for (int i=0;i<n;i++){
                newCoeffs[i]=this.coeffs[i]+right.coeffs[i];
            }
            return new MyPolynomial(newCoeffs);
        }
        else{
            double[] newCoeffs=new double[n];

            for (int i=0;i<m;i++){
                newCoeffs[i]=this.coeffs[i]+right.coeffs[i];
            }
            for (int j=(m+1);j<n;j++){
                newCoeffs[j]=right.coeffs[j];
            }
            return new MyPolynomial(newCoeffs);
        }
    }

    public MyPolynomial multiply(MyPolynomial right){
        int m = this.coeffs.length;
        int n = right.coeffs.length;
        double[] newCoeffs = new double[m+n-1];
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newCoeffs[i+j]+=this.coeffs[i]*right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPolynomial)) {return false;}
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result+Arrays.hashCode(coeffs);
        return result;
    }
}
