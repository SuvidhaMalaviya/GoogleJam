package GoogleJam;

import java.util.Scanner;

public class Parenting_Partnering_Returns {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T,si[],ei[],N[],i,j,k,l=0;
        char out[];
        String output[];
        boolean isimp=false,isover[];
        //1440

        do {
            T=sc.nextInt();
        }while (T<1 || T>100);

        N=new int[T];
        output=new String[T];

        for (i=0;i<T;i++)
        {
            output[i]="";
            do {
                N[i] = sc.nextInt();
            } while (N[i] < 2 || N[i] > 10);

            si = new int[N[i]];
            ei = new int[N[i]];
            out = new char[N[i]];
            isover=new boolean[N[i]];

            for (j = 0; j < N[i]; j++)
            {
                do {
                    si[j] = sc.nextInt();
                } while (si[j] < 0 || si[j] > 1440);

                do {
                    ei[j] = sc.nextInt();
                } while (ei[j] < 0 || ei[j] > 1440 || ei[j] < si[j]);

                if (j==0)
                {
                    out[j]='C';
                    isover[j]=true;
                }
                else
                {
                    if ((si[j]<=si[0] || si[j]>=ei[0])&& (ei[j]<=si[0] || ei[j]>=ei[0]))
                        isover[j]=true;
                }
            }

            for (j=1;j<N[i];j++)
            {
                //int flag=0;
                if (isover[j])
                {
                    l++;
                    if(l==1)
                    {
                        out[j]='C';
                    }
                    else
                    {
                        for(k=0;k<j;k++)
                        {
                            if (isover[k])
                            {
                                if (si[j] > si[k] || si[j] < ei[k])
                                {
                                    isover[j] = false;
                                    break;
                                }
                                out[j]='C';

                            }
                        }
                    }
                }
            }

            l=0;
            for (j=1;j<N[i];j++)
            {
                if (!isover[j])
                {
                    l++;
                    if(l==1)
                    {
                        out[j]='J';
                    }
                    else
                    {
                        for(k=0;k<j;k++)
                        {
                            if (!isover[k])
                            {
                                if (!((si[j] <= si[k] || si[j] >= ei[k]) && (ei[j]<=si[k] || ei[j]>=ei[k])))
                                {
                                    output[i]="impossible";
                                    //System.out.print("oo"+output[i]);
                                    break;
                                }
                                out[j]='J';
                                break;
                                //System.out.print("j,k"+j+" "+k);
                            }
                        }
                    }
                }
            }
            if (output[i].equals(""))
                output[i]=new String(out);
            System.out.print("out "+output[i]);
        }
    }

}
