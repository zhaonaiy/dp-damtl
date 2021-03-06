import java.io.*;

//import org.ejml.ops.RandomMatrices;
//import java.util.Random;

import org.AMTL_Matrix.*;
import org.AMTL_Matrix.MatrixOps.MatrixOps;
import org.AMTL_Matrix.Norms.Norms;

class ClientMessage_one implements Serializable{
	
	private int error;
	private int dim;
	private int Blas;

	private AMTL_Matrix A;
	private AMTL_Matrix nq; // New q, send to central server to test convergence of overall objective function value
	private AMTL_Matrix W; 
	private int index;

	// Constructor
	public ClientMessage_one(int dim, int Blas){
		this.dim = dim;
		this.error = 0;
		this.Blas = Blas;
		
		this.A = new AMTL_Matrix(this.dim, 1, this.Blas);//RandomMatrices.createRandom(this.ROW, (int)1, new Random());
		this.nq = new AMTL_Matrix(this.dim, 1, this.Blas);//RandomMatrices.createRandom(this.ROW, (int)1, new Random());


	}
	
	void setError(int errorCode){
		error = errorCode;
	}

	int getError(){
		return error;
	}


	AMTL_Matrix getVec(){
		return A;
	}

	public void copyVec(AMTL_Matrix a) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dim; i++){
			A.setDouble(i, 0, a.getDouble(i,0)); 
		}
	}
	
	AMTL_Matrix getQnew(){
		return this.nq;
	}
	
	public void copyQnew(AMTL_Matrix a) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dim; i++){
			nq.setDouble(i, 0, a.getDouble(i,0)); 
		}
	}
	
	int getId(){
		return this.index;
	}

	public void copyId(int a) {
		// TODO Auto-generated method stub
		this.index = a;
	}
	
	
}