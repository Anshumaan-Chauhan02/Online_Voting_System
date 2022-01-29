import java.util.*;
class projectVoter
 { 
    public int create_passcode(int n, ArrayList<Integer> a)
    { int x=(int)(Math.random()*n);
        for(int i=0;i<=a.size()-1;i++)
        { if(a.get(i)==x)
        {   return create_passcode(n,a);
        }
        else
        {  
        }
    }
   return x;
}
    public int checkid(int no , ArrayList<Integer> a)
    { int flag=1;
        for(int i=0;i<=a.size()-1;i++)
        { if(a.get(i)==no)
        {flag=0;
            break;
        }
        else
        { 
        }
    }
    return flag;
}
}