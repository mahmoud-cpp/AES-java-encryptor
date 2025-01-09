package com.mycompany.project;

import java.util.Scanner;

import java.io.RandomAccessFile;

import java.nio.channels.FileChannel;

import java.nio.ByteBuffer;


public class project
{
    
    byte [][] sbox = {
        { (byte) 0x63, (byte) 0x7C, (byte) 0x77, (byte) 0x7B, (byte) 0xF2, (byte) 0x6B, (byte) 0x6F, (byte) 0xC5, 
          (byte) 0x30, (byte) 0x01, (byte) 0x67, (byte) 0x2B, (byte) 0xFE, (byte) 0xD7, (byte) 0xAB, (byte) 0x76 },
        { (byte) 0xCA, (byte) 0x82, (byte) 0xC9, (byte) 0x7D, (byte) 0xFA, (byte) 0x59, (byte) 0x47, (byte) 0xF0, 
          (byte) 0xAD, (byte) 0xD4, (byte) 0xA2, (byte) 0xAF, (byte) 0x9C, (byte) 0xA4, (byte) 0x72, (byte) 0xC0 },
        { (byte) 0xB7, (byte) 0xFD, (byte) 0x93, (byte) 0x26, (byte) 0x36, (byte) 0x3F, (byte) 0xF7, (byte) 0xCC, 
          (byte) 0x34, (byte) 0xA5, (byte) 0xE5, (byte) 0xF1, (byte) 0x71, (byte) 0xD8, (byte) 0x31, (byte) 0x15 },
        { (byte) 0x04, (byte) 0xC7, (byte) 0x23, (byte) 0xC3, (byte) 0x18, (byte) 0x96, (byte) 0x05, (byte) 0x9A, 
          (byte) 0x07, (byte) 0x12, (byte) 0x80, (byte) 0xE2, (byte) 0xEB, (byte) 0x27, (byte) 0xB2, (byte) 0x75 },
        { (byte) 0x09, (byte) 0x83, (byte) 0x2C, (byte) 0x1A, (byte) 0x1B, (byte) 0x6E, (byte) 0x5A, (byte) 0xA0, 
          (byte) 0x52, (byte) 0x3B, (byte) 0xD6, (byte) 0xB3, (byte) 0x29, (byte) 0xE3, (byte) 0x2F, (byte) 0x84 },
        { (byte) 0x53, (byte) 0xD1, (byte) 0x00, (byte) 0xED, (byte) 0x20, (byte) 0xFC, (byte) 0xB1, (byte) 0x5B, 
          (byte) 0x6A, (byte) 0xCB, (byte) 0xBE, (byte) 0x39, (byte) 0x4A, (byte) 0x4C, (byte) 0x58, (byte) 0xCF },
        { (byte) 0xD0, (byte) 0xEF, (byte) 0xAA, (byte) 0xFB, (byte) 0x43, (byte) 0x4D, (byte) 0x33, (byte) 0x85, 
          (byte) 0x45, (byte) 0xF9, (byte) 0x02, (byte) 0x7F, (byte) 0x50, (byte) 0x3C, (byte) 0x9F, (byte) 0xA8 },
        { (byte) 0x51, (byte) 0xA3, (byte) 0x40, (byte) 0x8F, (byte) 0x92, (byte) 0x9D, (byte) 0x38, (byte) 0xF5, 
          (byte) 0xBC, (byte) 0xB6, (byte) 0xDA, (byte) 0x21, (byte) 0x10, (byte) 0xFF, (byte) 0xF3, (byte) 0xD2 },
        { (byte) 0xCD, (byte) 0x0C, (byte) 0x13, (byte) 0xEC, (byte) 0x5F, (byte) 0x97, (byte) 0x44, (byte) 0x17, 
          (byte) 0xC4, (byte) 0xA7, (byte) 0x7E, (byte) 0x3D, (byte) 0x64, (byte) 0x5D, (byte) 0x19, (byte) 0x73 },
        { (byte) 0x60, (byte) 0x81, (byte) 0x4F, (byte) 0xDC, (byte) 0x22, (byte) 0x2A, (byte) 0x90, (byte) 0x88, 
          (byte) 0x46, (byte) 0xEE, (byte) 0xB8, (byte) 0x14, (byte) 0xDE, (byte) 0x5E, (byte) 0x0B, (byte) 0xDB },
        { (byte) 0xE0, (byte) 0x32, (byte) 0x3A, (byte) 0x0A, (byte) 0x49, (byte) 0x06, (byte) 0x24, (byte) 0x5C, 
          (byte) 0xC2, (byte) 0xD3, (byte) 0xAC, (byte) 0x62, (byte) 0x91, (byte) 0x95, (byte) 0xE4, (byte) 0x79 },
        { (byte) 0xE7, (byte) 0xC8, (byte) 0x37, (byte) 0x6D, (byte) 0x8D, (byte) 0xD5, (byte) 0x4E, (byte) 0xA9, 
          (byte) 0x6C, (byte) 0x56, (byte) 0xF4, (byte) 0xEA, (byte) 0x65, (byte) 0x7A, (byte) 0xAE, (byte) 0x08 },
        { (byte) 0xBA, (byte) 0x78, (byte) 0x25, (byte) 0x2E, (byte) 0x1C, (byte) 0xA6, (byte) 0xB4, (byte) 0xC6, 
          (byte) 0xE8, (byte) 0xDD, (byte) 0x74, (byte) 0x1F, (byte) 0x4B, (byte) 0xBD, (byte) 0x8B, (byte) 0x8A },
        { (byte) 0x70, (byte) 0x3E, (byte) 0xB5, (byte) 0x66, (byte) 0x48, (byte) 0x03, (byte) 0xF6, (byte) 0x0E, 
          (byte) 0x61, (byte) 0x35, (byte) 0x57, (byte) 0xB9, (byte) 0x86, (byte) 0xC1, (byte) 0x1D, (byte) 0x9E },
        { (byte) 0xE1, (byte) 0xF8, (byte) 0x98, (byte) 0x11, (byte) 0x69, (byte) 0xD9, (byte) 0x8E, (byte) 0x94, 
          (byte) 0x9B, (byte) 0x1E, (byte) 0x87, (byte) 0xE9, (byte) 0xCE, (byte) 0x55, (byte) 0x28, (byte) 0xDF },
        { (byte) 0x8C, (byte) 0xA1, (byte) 0x89, (byte) 0x0D, (byte) 0xBF, (byte) 0xE6, (byte) 0x42, (byte) 0x68, 
          (byte) 0x41, (byte) 0x99, (byte) 0x2D, (byte) 0x0F, (byte) 0xB0, (byte) 0x54, (byte) 0xBB, (byte) 0x16 }
        };
    
    public void add_round_key(byte pt[][], byte key[][])
    {
        for (int i = 0; i < 4; i++)
            for (int p = 0; p < 4; p++)
                pt[i][p] = (byte) (pt[i][p] ^ key[i][p]);
        
 
    }
    
    public void subbytes(byte pt[][])
    {
        
        int val;
        
        for (int i = 0; i < 4; i++)
            for (int o = 0; o < 4; o++)//high value nibble is for row, low for column
            {
                
                val = pt[i][o] & 0xff;// Convert to an unsigned value
                
                pt[i][o] = sbox[ ( val & 0xf0) >> 4 ][ val & 0x0f  ];
            }
        
        
    }
    
    public void shiftrows(byte []row, byte y)
    {
        
        byte newr[] = new byte[4];
        
        byte num2 = y, num1 = 0, newpos = 0;
        
        
        
        for (;num2 < 4; num2++, newpos++)
            newr[newpos] = row[num2];
        
        for (;num1 != y; num1++, newpos++)
            newr[newpos] = row[num1];
        
        
        
        for(int i = 0; i < 4; i++)
            row[i] = newr[i];
        
    }
    
    
    
    public byte case2(byte x)
    {
        
        int temp = x & 0xff;
        
        temp = temp << 1;
        
        
        if ((temp & 0x100) != 0)
        {
            
            temp = temp ^ 0x1b;
            
        }
        
        return (byte) temp;
        
    }
    
    public byte case3(byte x)
    {
        
        byte temp = case2(x);
        
        return (byte) (temp ^ x);
        
    }
    
    public byte with_m(byte x, byte y)
    {
        
        
        switch (y) 
        {
            case 1:
                
                return x;
                
            case 2:
                
                return case2(x);
                
            case 3:
                
                return case3(x);
            
        }
   
        return 0;
    }
    
    public void mix_columns(byte pt[][])
    {
        
        byte fixed[][] = { 
            {2, 3, 1, 1},
            {1, 2, 3, 1},
            {1, 1, 2, 3}, 
            {3, 1, 1, 2}};
        
        byte [][] res = new byte[4][4];
        
        byte temp1, temp2;
        
        for (int i = 0; i < 4; i++)
            for (int r = 0; r < 4; r++)
            {
                
                temp1 = (byte) (with_m(pt[0][i], fixed[r][0]) ^ with_m(pt[1][i], fixed[r][1]));
                
                temp2 = (byte)  (  with_m(pt[2][i], fixed[r][2]) ^ with_m(pt[3][i], fixed[r][3]) );
                
                res[r][i] = (byte) ( temp1 ^ temp2);
                
            }
        
        for (int i = 0; i < 4; i++)
            for (int p = 0; p < 4; p++)
                pt[i][p] = res[i][p];
        
        
    }
    
    public void key_exp(byte [][]old, byte rcon)
    {
        
        byte bone[] = new byte[4];

        
        bone[0] = old[3][3];
        
        bone[1] = old[1][3];
        
        bone[2] = old[2][3];
        
        bone[3] = old[0][3];
        
        int val;
        
        for (int i = 0; i < 4; i++)
        {
            val = bone[i] & 0xff;
            
            bone[i] = sbox[ ( val & 0xf0) >> 4 ][ val & 0x0f  ];
            
        }
       
        
        bone[0] = (byte) (bone[0] ^ rcon);
        
        for (int i = 0; i < 4 ; i++)
        {
            
            bone[0] = (byte) (bone[0] ^ old[0][i]);
            old[0][i] = bone[0];

            bone[1] = (byte) (bone[1] ^ old[1][i]);
            old[1][i] = bone[1];
            
            bone[2] = (byte) (bone[2] ^ old[2][i]);
            old[2][i] = bone[2];
            
            bone[3] = (byte) (bone[3] ^ old[3][i]);
            old[3][i] = bone[3];
            
        }
        
    }
    
    public void steps(byte x[])
    {   
        byte [][] pt = new byte[4][4];//pt : plain text
        
        

        
       int o = 0;
        
       for (int i = 0; i < 4; i++)
            for (int p = 0; p < 4; p++, o++){
                pt[p][i] = x[o];
               
            }
        
        
        byte[][] key = { 
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0} }; //whaterver was the source
        
        
        
        byte rcon[] = {
       (byte) 0x01, // RCON 1
       (byte) 0x02, // RCON 2
       (byte) 0x04, // RCON 3
       (byte) 0x08, // RCON 4
       (byte) 0x10, // RCON 5
       (byte) 0x20, // RCON 6 
       (byte) 0x40, // RCON 7
       (byte) 0x80, // RCON 8
       (byte) 0x1B, // RCON 9
       (byte) 0x36  // RCON 10 
        };
        
        project roject = new project();
        
        
        roject.add_round_key(pt, key);
        
        for (int n = 1; n != 10; n++)
        {
            
            roject.subbytes(pt);
            
            for (byte i = 1; i < 4; i++)
                roject.shiftrows(pt[i], i);
 
           roject.mix_columns(pt);
           
           roject.key_exp(key, rcon[n -1]);
            
           roject.add_round_key(pt, key);
         
        }
        
        roject.subbytes(pt);
         
        for (byte i = 1; i < 4; i++)
            roject.shiftrows(pt[i], i);
         
        roject.key_exp(key, rcon[9] );
        
        roject.add_round_key(pt, key);
        
        
        o = 0;
        
        for (int i = 0; i < 4; i++)
            for (int p = 0; p < 4; p++, o++)
                x[o] = pt[p][i];
        

    }
    
    public static void main(String srgs[])
    {
        
        String name;
        int num;
        Scanner scanner = new Scanner(System.in);
      
        System.out.print("enter 1 for encrypt , 2 for decrypt \n");
        
        num = scanner.nextInt();
        name = scanner.nextLine();
        
        if (num == 1)
        {
            
            System.out.print("enter path of file to encrypt\n");
        
            name = scanner.nextLine();
        
            try (
            RandomAccessFile one = new RandomAccessFile(name, "rw"); 
            RandomAccessFile two = new RandomAccessFile("res.oop", "rw");
            FileChannel filech = one.getChannel();
            FileChannel res = two.getChannel();)
            {
                
                ByteBuffer bytes = ByteBuffer.allocate(16);
                
        
                int gate;
                
                project roject = new project();
                
                while (true)
                {
                    
                    gate = filech.read(bytes);
                    
                    byte[] info = new byte[16];
            
                    if (gate == 16)
                    {
                        
                        bytes.flip();
                        bytes.get(info);
                        
                    }
                    else if (gate < 16 && gate != -1)
                    {
                        
                        System.out.print("\n\n (it start from 1)( number of valid bytes) the number is " + (gate) + "\n\n");//the bytes to read
                        
                        byte[] info2 = new byte[gate];
                        
                        bytes.flip();
                        bytes.get(info2);
                        
                        System.arraycopy(info2, 0, info, 0, gate);
                        
                    }
                    else if ( gate == -1)
                        break;

                    roject.steps(info);
                  
                    bytes.flip();
                     
                    bytes.limit(bytes.capacity());
                     
                    bytes.put(info);
                    bytes.flip();
                     
                     
                     
                    while(bytes.hasRemaining()) 
                        res.write(bytes);
             
                    bytes.clear();
              
                }
            
            
            }catch (java.io.FileNotFoundException e){
                System.out.print("an i/o error occurred : " + e.getMessage() + "\n ");}
            catch (java.io.IOException e){
                System.out.print("file not found : " + e.getMessage() + "\n ");} 
        
        } 
        else if (num == 2)
        {//decode
            
            byte[][] key = { 
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0} }; //whaterver was the source
        
            decode objec = new decode();
        
            System.out.print("enter path of file to decrypt : \n");
        
            name = scanner.nextLine();
        
            String name2;
        
            System.out.print("\nenter name and extention for the decrypted file\n");
        
            name2 = scanner.nextLine();
        
            System.out.print("enter number of vald bytes \n");
        
            num = scanner.nextInt();//use it to know how many bytes to take from last 128 bit
        
            ByteBuffer bytes = ByteBuffer.allocate(16);
        
            int gate;
        
            byte[] info = new byte[16];
        
            try (
            RandomAccessFile one = new RandomAccessFile(name, "rw"); 
            RandomAccessFile two = new RandomAccessFile(name2, "rw");
            FileChannel filech = one.getChannel();
            FileChannel res = two.getChannel();)
            {
                while (true)
                {
                    
                    gate = filech.read(bytes);

                    if ( gate == -1)
                        break;
                    
                    bytes.flip();
                    bytes.get(info);
                
                    objec.steps_to_de(info, key);   
                
                    bytes.clear();  
                    bytes.put(new byte[16]);
                    bytes.clear();     
                
                    if (one.length() == filech.position() && num != 16)
                       bytes.put(info, 0, num);
                    else
                       bytes.put(info);
                
                
                    bytes.flip();
                    bytes.clear();
                    while(bytes.hasRemaining()) 
                       res.write(bytes);
             
               
                    bytes.clear();  
                    bytes.put(new byte[16]);
                    bytes.clear();  
                
                }
                
            }catch (java.io.FileNotFoundException e)
            {System.out.print("an i/o error occurred : " + e.getMessage() + "\n ");}
            catch (java.io.IOException e){
                System.out.print("file not found : " + e.getMessage() + "\n ");
            } 
        }
    }
        
}