import java.io.*;
import java.util.*;


public class ReadFile {
    public String line;
    public Integer nline = 0;

    ArrayList<ArrayList<Integer>> readNumbers(){
        BufferedReader reader= null;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        try{
            reader = new BufferedReader (new FileReader("new1.txt")); //Variables initialization
            StringTokenizer lineTokens;
            String token;
            int columns = -1;
            int lines = -1;
            int entline;
            int entcol;
            int ncols = -1;
            int entrnum = 0;

            

            line = reader.readLine();  
            while(line!=null){
                if (!(line.trim().equals(" "))) {
                        lineTokens = new StringTokenizer(line);
                        nline += 1;
                        if(lineTokens.hasMoreTokens()){ 
                            token = lineTokens.nextToken();
                            if (nline == 1) {
                                ArrayList<Integer> list1 = new ArrayList<Integer>();                                   //checking the first line
                                if (isInteger(token)){
                                    lines = Integer.parseInt(token);
                                    list1.add(lines);
                                }else{
                                    System.out.println("You have not given number for number of lines. Please check your txt file!");
                                }
                                token = lineTokens.nextToken();
                                if (isInteger(token)){
                                    columns = Integer.parseInt(token);
                                    list1.add(columns);
                                }else{
                                    System.out.println("You have not given number for number of columns. Please check your txt file!");
                                }
                                list.add(list1);
                            }else if(nline == 2){ 
                                ArrayList<Integer> list1 = new ArrayList<Integer>();                              //checking the second line
                                if (isInteger(token)){
                                    entline = Integer.parseInt(token);
                                    list1.add(entline);
                                }else{
                                    System.out.println("You have not given number for entrance's line. Please check your txt file!");
                                }
                                token = lineTokens.nextToken();
                                if (isInteger(token)){
                                    entcol = Integer.parseInt(token);
                                    list1.add(entcol);
                                }else{
                                    System.out.println("You have not given number for entrance's column. Please check your txt file!");
                                }
                                list.add(list1);
                            }else{
                                ArrayList<Integer> list1 = new ArrayList<Integer>();                    //checking the other txt file lines
                                if (isInteger(token)){
                                    list1.add(Integer.parseInt(token));
                                    if (nline == 3){
                                        ncols = 1;
                                    }
                                }
                                if(lineTokens.hasMoreTokens()){
                                    while(lineTokens.hasMoreTokens()){
                                        token = lineTokens.nextToken();
                                        if (isInteger(token) ){
                                            list1.add(Integer.parseInt(token));
                                            if (nline == 3){
                                                ncols += 1;
                                            }
                                        }else if(token.equalsIgnoreCase("E")){
                                            list1.add(2);
                                            entrnum += 1;
                                            if (nline == 3){
                                                ncols += 1;
                                            }
                                        }else{
                                            reader.close();
                                            throw new Exception();
                                        }
                                        
                                    }
                                }list.add(list1);
                                if (nline == 3 && ncols != columns){
                                    reader.close();
                                    throw new Exception("Wrong number of coulmns");
                                }
                            }
                        }  
               }line = reader.readLine();
            }if ((nline - 2) != lines && lines >= 0){              //checks if the labyritnh does not have less or more lines
                reader.close();
                throw new InputMismatchException();
            }
            if (entrnum != 1){
                reader.close();
                throw new Exception();
            }
            reader.close();    
    }catch (Exception e){
        System.err.println("Error Occured! Program Finished!");
    }System.out.println(list);
    return list;  
}


    public boolean isInteger(String linetoken){
        try{
            int res = Integer.parseInt(linetoken);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
}


