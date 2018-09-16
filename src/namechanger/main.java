/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namechanger;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Javi
 */
public class main {
    public static void main(String [] args) throws IOException{
        NameChanger nc = new NameChanger(true/*subDir*/, true/*beginWithMayus*/, true/*changeWithLowBar*/, 
                false/*changeWithScript*/, false/*changeWithMayus*/, false/*changeWithoutMayus*/, 
                true/*changeDirsName*/, true/*changeFileName*/, true/*eraseAccentMarks*/, true/*deleteLastSpace*/,
                /*"C:\\Users\\Javi\\Documents\\nameChanger"*/"C:\\Users\\Javi\\Desktop\\olala");

        //nc.changeTheNames();
        
        File f = new File("C:");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getParent());
        System.out.println(f.getPath());
    }
}
