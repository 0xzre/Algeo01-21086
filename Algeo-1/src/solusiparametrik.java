

public class solusiparametrik {
  public static void solusi() {

    int nRows, nCols, i, j;
    nRows = 3;
    nCols = 4;
    i = nRows - 1;
    j = nCols - 1;
    Matrix matrix = new Matrix(nRows, nCols);
    matrix.readMatrixCLI(nRows, nCols);
    matrix.gaussJordan();


    if(matrix.matrix[i][j - 1] == 1)
    {
        System.out.println("solusi spl unik");
    }
    else if((matrix.matrix[i][j - 1] == 0) && matrix.matrix[i][j] != 0)
    {
        System.out.println("tidak memiliki solusi");
    }
    else if((matrix.matrix[i][j - 1] == 0) && matrix.matrix[i][j] == 0)
    {
        System.out.println("solusi spl banyak");
    }

    }
  public static void main(String[] args) {
    int nRows, nCols;
    nRows = 4;
    nCols = 7;
    Matrix matrix = new Matrix(nRows, nCols);
    matrix.readMatrixCLI(nRows, nCols);
    matrix.gaussJordan();


    double[] num = new double[matrix.cols -1];
    String[] str = new String[matrix.cols -1];

    for(int i = 0; i < num.length; i++) {
      num[i] = -99999;
    }

    for(int i = 0; i < str.length; i++) {
      str[i] = "";
    }

    for(int i = matrix.rows - 1; i >= 0; i--) {
      for(int j = 0; j < matrix.cols - 1; j++) {
        if(matrix.matrix[i][j] == 1.00) {
          for(int k = j+1; k < str.length; k++) {
            if(str[k] == "" && num[k] == -99999) {
              str[k] += ((char) (97 + k));
            }
          }

          num[j] = matrix.matrix[i][matrix.cols -1];

          for(int k = j+1; k < matrix.cols -1; k++) {
            if(num[k] != -99999) {
              num[j] += matrix.matrix[i][k]*num[k];
            } else {
              if(str[j] == "") {
                if(matrix.matrix[i][k] > 0.0) {
                  str[j] += "-" + matrix.matrix[i][k] + ((char) (97 + k)) + " "; 
                } else if(matrix.matrix[i][k] < 0.0) {
                  str[j] += (-matrix.matrix[i][k]) + ((char) (97 + k)) + " ";
                }
              } else {
                if(matrix.matrix[i][k] > 0.0) {
                  str[j] += "- " + matrix.matrix[i][k] + ((char) (97 + k)) + " "; 
                } else if(matrix.matrix[i][k] < 0.0) {
                  str[j] += "+ " + (-matrix.matrix[i][k]) + ((char) (97 + k)) + " ";
                }
              }
            }
          }
          break;
        }
      }
    }

    for(int i = 0; i < num.length; i++) {
      System.out.print("x" + (i+1) + ": ");
      if(num[i] == -99999) {
        System.out.println(str[i]);
      } else {
        if(num[i] == 0.0) {
          System.out.println(str[i]);
        } else {
          System.out.println(num[i] + " " + str[i]);
        }
      }
    }
  }
}
