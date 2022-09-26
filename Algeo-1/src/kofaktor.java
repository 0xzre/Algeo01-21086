public class kofaktor {
    public class Matrix {
        double[][] matrix;
        int rows;
        int cols;

        public static void main(String[] args){
            System.out.println(" ");
        };

        public Matrix(int nRows, int nCols){
            this.rows = nRows;
            this.cols = nCols;
            this.matrix = new double[nRows][nCols];
        }
        public Matrix copyMatrix(){
            Matrix mOut = new Matrix(this.rows, this.cols);
            int i, j;
            mOut.rows = this.rows;
            mOut.cols = this.cols;
            for(i=0; i<this.rows; i++){
                for(j=0; j<this.cols; j++){
                    mOut.matrix[i][j] = this.matrix[i][j];
                }
            }
            return mOut;
        }
        public double determinanKofaktor(){
            double det=0;
            int i,j,k,x,y;
            Matrix matrixNew = new Matrix((this.rows-1),(this.cols-1));
            if(this.rows==2 && this.cols==2){ //BASIS
                det = ((this.matrix[0][0]*this.matrix[1][1])-(this.matrix[0][1]*this.matrix[1][0]));
                return det;
            }else{
                for(i=0; i<this.cols; i++){
                    if(this.matrix[0][i] != 0){
                        y=0;
                        for(j=0; j<this.rows; j++){
                            x=0;
                            for(k=0; k<this.cols; k++){
                                if(k!=i){ //Membuat matrikskofaktor
                                    matrixNew.matrix[y][x] = this.matrix[j][k];
                                    x++;
                                }
                            }
                            if(j!=0){
                                y++;
                            }
                        }
                        if(i%2==0){
                            det += this.matrix[0][i] * matrixNew.determinanKofaktor();
                        }else{
                            det -= this.matrix[0][i] * matrixNew.determinanKofaktor();
                        }
                    }
                }
                return det;
            }
        }

        public void reduceMatrix(double M[][], int i, int j){
            int k,l,m,n;
            double T[][];
            T = new double[this.rows][this.cols];
            k=0;
            m=0;
            while(m<this.rows){
                if(k == i){
                    m+=1;
                }
                if(m != this.rows){
                    for(l=0; l<this.cols; l++){
                        T[k][l] = this.matrix[m][l];
                    }
                }
                k += 1;
                m += 1;
            }

            l=0;
            n=0;
            while(n<this.cols){
                if(l==j){
                    n+=1;
                }
                if(n != this.cols){
                    for(k=0; k<this.rows; k++){
                        T[k][l] = T[k][n];
                    }
                }
                l+=1;
                n+=1;
            }
            for(i=0; i<this.cols-1; i++){
                for(j=0; j<this.cols-1; j++){
                    M[i][j] = T[i][j];
                }
            }
        }

        public void kofaktor(){
            int i,j;
            double temp;
            double[][] mNew;
            mNew = new double[this.rows-1][this.cols-1];
            Matrix m1 = new Matrix((this.rows-1),(this.cols-1));
            Matrix m2 = new Matrix((this.rows-1),(this.cols-1));

            if((this.rows == 2) && (this.cols ==2)){
                temp = this.matrix[0][0];
                this.matrix[0][0] = this.matrix[1][1];
                this.matrix[1][1] = temp;
                temp = this.matrix[0][1];
                this.matrix[0][1] = -(this.matrix[1][0]);
                this.matrix[1][0] = -(temp);
            }else{
                for(i=0; i<this.rows; i++){
                    for(j=0; j<this.cols; j++){
                        this.reduceMatrix(mNew,i,j);
                        m1.copyMatrix();
                        m2.matrix[i][j] = m1.determinanKofaktor();

                        if((i+j)%2 != 0){
                            m2.matrix[i][j] = -(m2.matrix[i][j]);
                        }
                    }
                }
                for(i=0; i<this.rows; i++){
                    for(j=0; j<this.cols; j++){
                        this.matrix[i][j] = m2.matrix[i][j];
                    }
                }
            }
        }

        public void transpose(){
            int i,j;
            double[][] mNew;
            mNew = new double[this.rows][this.cols];
            for(i=0; i<this.rows; i++){
                for(j=0; j<this.cols; j++){
                    mNew[j][i] = this.matrix[i][j];
                }
            }
            for(i=0; i<this.rows; i++){
                for(j=0; j<this.cols; j++){
                    this.matrix[i][j] = mNew[i][j];
                }
            }
        }

        public void adjoin(){
            this.kofaktor();
            this.transpose();
        }

        public void invers(){
            int i,j;
            double[][] mNew;
            mNew = new double[this.rows][this.cols];
            if(this.determinanKofaktor()!=0){
                this.adjoin();
                for(i=0; i<this.rows; i++){
                    for(j=0; j<this.cols; j++){
                        mNew[i][j] = this.matrix[i][j]/this.determinanKofaktor();
                    }
                }
                this.copyMatrix();
            }
        }
    }
}
