
package com.mycompany.project;

public class decode {
    
    byte[][] invSBox = {
    {(byte) 0x52, (byte) 0x09, (byte) 0x6A, (byte) 0xD5, (byte) 0x30, (byte) 0x36, (byte) 0xA5, (byte) 0x38, 
     (byte) 0xBF, (byte) 0x40, (byte) 0xA3, (byte) 0x9E, (byte) 0x81, (byte) 0xF3, (byte) 0xD7, (byte) 0xFB},
    {(byte) 0x7C, (byte) 0xE3, (byte) 0x39, (byte) 0x82, (byte) 0x9B, (byte) 0x2F, (byte) 0xFF, (byte) 0x87, 
     (byte) 0x34, (byte) 0x8E, (byte) 0x43, (byte) 0x44, (byte) 0xC4, (byte) 0xDE, (byte) 0xE9, (byte) 0xCB},
    {(byte) 0x54, (byte) 0x7B, (byte) 0x94, (byte) 0x32, (byte) 0xA6, (byte) 0xC2, (byte) 0x23, (byte) 0x3D, 
     (byte) 0xEE, (byte) 0x4C, (byte) 0x95, (byte) 0x0B, (byte) 0x42, (byte) 0xFA, (byte) 0xC3, (byte) 0x4E},
    {(byte) 0x08, (byte) 0x2E, (byte) 0xA1, (byte) 0x66, (byte) 0x28, (byte) 0xD9, (byte) 0x24, (byte) 0xB2, 
     (byte) 0x76, (byte) 0x5B, (byte) 0xA2, (byte) 0x49, (byte) 0x6D, (byte) 0x8B, (byte) 0xD1, (byte) 0x25},
    {(byte) 0x72, (byte) 0xF8, (byte) 0xF6, (byte) 0x64, (byte) 0x86, (byte) 0x68, (byte) 0x98, (byte) 0x16, 
     (byte) 0xD4, (byte) 0xA4, (byte) 0x5C, (byte) 0xCC, (byte) 0x5D, (byte) 0x65, (byte) 0xB6, (byte) 0x92},
    {(byte) 0x6C, (byte) 0x70, (byte) 0x48, (byte) 0x50, (byte) 0xFD, (byte) 0xED, (byte) 0xB9, (byte) 0xDA, 
     (byte) 0x5E, (byte) 0x15, (byte) 0x46, (byte) 0x57, (byte) 0xA7, (byte) 0x8D, (byte) 0x9D, (byte) 0x84},
    {(byte) 0x90, (byte) 0xD8, (byte) 0xAB, (byte) 0x00, (byte) 0x8C, (byte) 0xBC, (byte) 0xD3, (byte) 0x0A, 
     (byte) 0xF7, (byte) 0xE4, (byte) 0x58, (byte) 0x05, (byte) 0xB8, (byte) 0xB3, (byte) 0x45, (byte) 0x06},
    {(byte) 0xD0, (byte) 0x2C, (byte) 0x1E, (byte) 0x8F, (byte) 0xCA, (byte) 0x3F, (byte) 0x0F, (byte) 0x02, 
     (byte) 0xC1, (byte) 0xAF, (byte) 0xBD, (byte) 0x03, (byte) 0x01, (byte) 0x13, (byte) 0x8A, (byte) 0x6B},
    {(byte) 0x3A, (byte) 0x91, (byte) 0x11, (byte) 0x41, (byte) 0x4F, (byte) 0x67, (byte) 0xDC, (byte) 0xEA, 
     (byte) 0x97, (byte) 0xF2, (byte) 0xCF, (byte) 0xCE, (byte) 0xF0, (byte) 0xB4, (byte) 0xE6, (byte) 0x73},
    {(byte) 0x96, (byte) 0xAC, (byte) 0x74, (byte) 0x22, (byte) 0xE7, (byte) 0xAD, (byte) 0x35, (byte) 0x85, 
     (byte) 0xE2, (byte) 0xF9, (byte) 0x37, (byte) 0xE8, (byte) 0x1C, (byte) 0x75, (byte) 0xDF, (byte) 0x6E},
    {(byte) 0x47, (byte) 0xF1, (byte) 0x1A, (byte) 0x71, (byte) 0x1D, (byte) 0x29, (byte) 0xC5, (byte) 0x89, 
     (byte) 0x6F, (byte) 0xB7, (byte) 0x62, (byte) 0x0E, (byte) 0xAA, (byte) 0x18, (byte) 0xBE, (byte) 0x1B},
    {(byte) 0xFC, (byte) 0x56, (byte) 0x3E, (byte) 0x4B, (byte) 0xC6, (byte) 0xD2, (byte) 0x79, (byte) 0x20, 
     (byte) 0x9A, (byte) 0xDB, (byte) 0xC0, (byte) 0xFE, (byte) 0x78, (byte) 0xCD, (byte) 0x5A, (byte) 0xF4},
    {(byte) 0x1F, (byte) 0xDD, (byte) 0xA8, (byte) 0x33, (byte) 0x88, (byte) 0x07, (byte) 0xC7, (byte) 0x31, 
     (byte) 0xB1, (byte) 0x12, (byte) 0x10, (byte) 0x59, (byte) 0x27, (byte) 0x80, (byte) 0xEC, (byte) 0x5F},
    {(byte) 0x60, (byte) 0x51, (byte) 0x7F, (byte) 0xA9, (byte) 0x19, (byte) 0xB5, (byte) 0x4A, (byte) 0x0D, 
     (byte) 0x2D, (byte) 0xE5, (byte) 0x7A, (byte) 0x9F, (byte) 0x93, (byte) 0xC9, (byte) 0x9C, (byte) 0xEF},
    {(byte) 0xA0, (byte) 0xE0, (byte) 0x3B, (byte) 0x4D, (byte) 0xAE, (byte) 0x2A, (byte) 0xF5, (byte) 0xB0, 
     (byte) 0xC8, (byte) 0xEB, (byte) 0xBB, (byte) 0x3C, (byte) 0x83, (byte) 0x53, (byte) 0x99, (byte) 0x61},
    {(byte) 0x17, (byte) 0x2B, (byte) 0x04, (byte) 0x7E, (byte) 0xBA, (byte) 0x77, (byte) 0xD6, (byte) 0x26, 
     (byte) 0xE1, (byte) 0x69, (byte) 0x14, (byte) 0x63, (byte) 0x55, (byte) 0x21, (byte) 0x0C, (byte) 0x7D}
};
    
     
    
    public void keys_maker(byte keys [][][])
    {
        project pro = new project();
        byte rcon[] = {
       (byte) 0x01, // RCON[1]
       (byte) 0x02, // RCON[2]
       (byte) 0x04, // RCON[3]
       (byte) 0x08, // RCON[4]
       (byte) 0x10, // RCON[5]
       (byte) 0x20, // RCON[6]
       (byte) 0x40, // RCON[7]
       (byte) 0x80, // RCON[8]
       (byte) 0x1B, // RCON[9]
       (byte) 0x36  // RCON[10]
        };
        
        
        
        for (int i = 0; i < 10; i++)
        {
            
            for (int ii = 0; ii < 4; ii++) 
            System.arraycopy(keys[i][ii], 0, keys[i+1][ii], 0, 4);
            
            pro.key_exp(keys[i+1], rcon[i]);
            
            
        }
        
    }
    
    public void invsubbytes(byte pt[][])
    {
        
        int val;
        
        for (int i = 0; i < 4; i++)
            for (int o = 0; o < 4; o++)//high value nibble is for row, low for column
            {
                
                val = pt[i][o] & 0xff;
                
                pt[i][o] = invSBox[ ( val & 0xf0) >> 4 ][ val & 0x0f  ];
            }

        
    }
    
    public void invshiftrows(byte []row, byte y)
    {
        

        byte newr[] = new byte[4];
        
        byte num2 = (byte) (4 - y), newpos = 0;
        

        for (;num2 < 4;newpos++, num2++)
            newr[newpos] = row[num2];
        
        for (int i = 0;i != 4 - y; i++, newpos++)
            newr[newpos] = row[i];

        for (int i = 0; i < 4; i++)
            row[i] = newr[i];
        
    }
    

        
    public byte with_m(byte x, byte y)
    {
        
      
        project pro = new project();
        
        byte one, two, three;
        
        one = pro.case2(x);
         
        two = pro.case2(one);
       
        switch (y) 
        {
            case 0x0E:
                
                
                three = pro.case2(two);
                
                return (byte) (one ^ (byte) ( two ^ three));
                
            case 0x0B:
                
                three = pro.case2(two);
                return (byte) (x ^ (byte) ( three ^ one));
                
                
            case 0x0D:
                
                three = pro.case2(two);

                
                return (byte) (x ^ (byte) ( two ^ three));
                
            case 0x09:
                
                three = pro.case2(two);

            return (byte) (x ^ three);
            
        }

        return x;
    }
    
    public void invmix_columns(byte pt[][])
    {
        
         byte fixed[][] = { 
            {(byte) 0x0E, (byte) 0x0B, (byte) 0x0D, (byte) 0x09},
            {(byte) 0x09, (byte) 0x0E, (byte) 0x0B, (byte) 0x0D},
            {(byte) 0x0D, (byte) 0x09, (byte) 0x0E, (byte) 0x0B}, 
            {(byte) 0x0B, (byte) 0x0D, (byte) 0x09, (byte) 0x0E}
                
            };
         
         byte [][] res = new byte[4][4];
        
        byte temp1, temp2;
        
        for (int i = 0; i < 4; i++)
            for (int r = 0; r < 4; r++)
            {
                
                temp1 = (byte) (with_m(pt[0][i], fixed[r][0]) ^ with_m(pt[1][i], fixed[r][1]));
                

                
                temp2 = (byte)  (  with_m(pt[2][i], fixed[r][2]) ^ with_m(pt[3][i], fixed[r][3]) );
                
                
                res[r][i] = (byte) ( temp1 ^ temp2 );
                
            }
        
        
        for (int i = 0; i < 4; i++)
            for (int p = 0; p < 4; p++)
                pt[i][p] = res[i][p];
        
    }
    
    public void steps_to_de(byte x[], byte key[][])// pt meaning plaintext
    {
        
        project pro = new project();
        byte [][] pt = new byte[4][4];//pt : plain text
        
        
        int o = 0;
        
        for (int i = 0; i < 4; i++)
            for (int p = 0; p < 4; p++, o++)
                pt[p][i] = x[o];
        
        
        byte keys [][][] = new byte[11][4][4];
        
        for (int i = 0; i < 4; i++) 
            System.arraycopy(key[i], 0, keys[0][i], 0, 4);
        
        keys_maker(keys);
        
        //start
        
        pro.add_round_key(pt, keys[10]);
        
         for (int n = 1; n != 10; n++)
        {
             
            
            for (byte i = 1; i < 4; i++)
                invshiftrows(pt[i], i);
            
            invsubbytes(pt);
               
            
            
            pro.add_round_key(pt, keys[ 10 - n ]);

            invmix_columns(pt);
        }
         
         for (byte i = 1; i < 4; i++)
            invshiftrows(pt[i], i);
         
        invsubbytes(pt);
          

        
        pro.add_round_key(pt, keys[0]);
        
        
        o = 0;
        
        for (int i = 0; i < 4; i++)
            for (int p = 0; p < 4; p++, o++)
                x[o] = pt[p][i];
        
        
 
        
    }
    
}
