/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namechanger;

/**
 *
 * @author Javi
 */
public class main {
    public static void main(String [] args){
        NameChanger nc = new NameChanger(true/*subDir*/, true/*beginWithMayus*/, true/*changeWithLowBar*/, 
                false/*changeWithScript*/, false/*changeWithMayus*/, false/*changeWithoutMayus*/, 
                true/*changeDirsName*/, true/*changeFileName*/, true/*eraseAccentMarks*/, true/*deleteLastSpace*/,
                /*"C:\\Users\\Javi\\Documents\\nameChanger"*/"C:\\Users\\Javi\\Desktop\\olala");

        nc.changeTheNames();
        
    }
}
