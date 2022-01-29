import java.util.*;
import java.io.*;
class Vote extends projectVoter
{
    public static void main(String args[])throws IOException
    {  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
        System.out.println("Enter number of positions in the election");
        int n=Integer.parseInt(br.readLine());
        String positions[]=new String[n];
        System.out.println("Enter the positions");
        for(int i=0;i<=n-1;i++)
        {positions[i]=br.readLine();
        }
    
    
        ArrayList<String> nameofcandidates=new ArrayList<String>();
        ArrayList<Integer> no_of_c= new ArrayList<Integer>();
        int countvotes[][]=new int[n][];
        for(int i=0;i<=n-1;i++)
        { System.out.println("Enter number of candidates standing for the position of :"+positions[i]);
          int nu=Integer.parseInt(br.readLine());
          no_of_c.add(nu);
          countvotes[i]=new int[nu];
          for(int j=0;j<=nu-1;j++)
          { countvotes[i][j]=0;
              System.out.println("Enter the name of candidate standing for:"+positions[i]);
              String na=br.readLine();
              nameofcandidates.add(na);
            }
        }
        
        System.out.println("Enter number of students in College");
        int n1=Integer.parseInt(br.readLine());
        Vote x1=new Vote();
        int whomvoted[][]=new int[n1][n];
        String name1[]=new String[n1];
        String college_id[]=new String[n1];
        ArrayList<Integer> passcode=new ArrayList<Integer>();
        ArrayList<Integer> id=new ArrayList<Integer>();
        for(int i=0;i<=n1-1;i++)
        { System.out.println("Enter name of the student ");
            String na=br.readLine();
            System.out.println("Enter college id of student");
            String ids=br.readLine();
            name1[i]=na;
            college_id[i]=ids;
            int r= x1.create_passcode(n1,passcode);
            System.out.println("Password for student is :\t"+r);
            passcode.add(r);
         }
            
            ArrayList<Integer> checkpass=new ArrayList<Integer>();
            int choice=1;
            while(choice==1||choice==2||choice==3||choice==4)
            {
            System.out.println("Enter 1-> to vote 2-> to check who voted whom 3->to see result 4-> to exit ");
            choice=Integer.parseInt(br.readLine());
            switch(choice)
            { case 1:   System.out.println("Enter your id and passcode");
                        String namepass=br.readLine();
                        int pass=Integer.parseInt(br.readLine());
                        int check=x1.checkid(pass,id);
                        int check2=x1.checkid(pass,checkpass);
                        int crosscheck=passcode.indexOf(pass);
                        String idcheck= college_id[crosscheck];
                        if(check==0||(idcheck.equals(namepass)==false))
                        { System.out.println("Incorrect password");
                            break;
                        }
                        else if(check2==0)
                        {System.out.println("You have already voted");
                            break;
                        }
                        else
                        { int index=passcode.indexOf(pass);
                            checkpass.add(pass);
                            
                           for(int i=0;i<=n-1;i++)
                           {
                            System.out.println(positions[i]);
                            for(int j=0;j<=no_of_c.get(i)-1;j++)
                            { if(i==0)
                                {System.out.println(nameofcandidates.get(j));
                            }
                            else
                            { int ex=0;
                                for(int k=0;k<=i-1;k++)
                                { ex=ex+no_of_c.get(k);
                                }
                                System.out.println(nameofcandidates.get(ex+j));
                            }
                        }
                            System.out.println("Enter 0,1,... to vote for following candidates");
                            int voting_no=Integer.parseInt(br.readLine());
                            whomvoted[index][i]=voting_no;
                            countvotes[i][voting_no]++;
                            }
                         }
                        break;
            
              case 2:  System.out.println("Enter the id number of student to check he/she voted which candidate");
                        String idsee=br.readLine();
                        int y=-1;
                        int flag=0;
                        for(int i=0;i<=n1-1;i++)
                        { if(idsee.equalsIgnoreCase(college_id[i])==true)
                            { y=i;
                                flag=1;
                            }
                        }
                        if(flag==0)
                        { System.out.println("Student with this id doesn't exist");
                        }
                        else
                        { int cp=x1.checkid(passcode.get(y),checkpass);
                            if(cp==0)
                            {System.out.println("This student has not voted yet");
                            }
                            else
                            { for(int i=0;i<=n-1;i++)
                                {
                                    System.out.println(positions[i]+":");
                                    for(int j=0;j<=no_of_c.get(i)-1;j++)
                                    { if(i==0)
                                        {System.out.println(nameofcandidates.get(whomvoted[y][i]));
                                        }
                                        else
                                        {int yc=0;
                                            for(int k=0;k<=i-1;k++)
                                            { yc=yc+no_of_c.get(k);
                                            }
                                            System.out.println(nameofcandidates.get(yc+whomvoted[y][i]));
                                        }
                                        }
                            }
                        }
                    }
                            break;
              case 3: for(int i=0;i<=n-1;i++)
                        { int y4=0;
                            System.out.println(positions[i]);
                            for(int j=0;j<=no_of_c.get(i)-1;j++)
                            { if(i!=0)
                                {for(int k=0;k<=i-1;k++)
                                { y4=y4+no_of_c.get(k);
                                }
                                System.out.println(nameofcandidates.get(y4+j)+" "+"got"+countvotes[i][j]+" "+"votes");
                            }
                            else
                            {
                                System.out.println(nameofcandidates.get(j)+" "+"got"+countvotes[i][j]+" "+"votes");
                            }
                        }
                        }
                  
              
              case 4: System.exit(1);
              
              default: System.out.println("Wrong input");
            }
        }
    }
}