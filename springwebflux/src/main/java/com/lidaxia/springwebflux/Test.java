package com.lidaxia.springwebflux;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/29 11:32（
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        short s = 128;
        s+=1;
        System.out.println(s);

//        File file = new File("D:\\ideause\\fizz-manager-professional-2.3.3\\test\\test\\fizz-manager-professional-2.3.3\\BOOT-INF\\lib\\te");
//        File[] files = file.listFiles();
//        for (File f : files) {
//            String name = f.getName().replace("-2.8.0.RELEASE.jar", "");
//            System.out.println("args = " +
//                    name);
//            String cmd = "mvn install:install-file -Dfile=D:\\ideause\\fizz-manager-professional-2.3.3\\test\\test\\fizz-manager-professional-2.3.3\\BOOT-INF\\lib\\" + name + ".RELEASE.jar  -DgroupId=org.springblade -DartifactId=" + name + " -Dversion=2.8.0 -Dpackaging=jar";
//            runCMD(cmd);
//        }
    }

    public static boolean runCMD(String cmd) throws IOException, InterruptedException {
        final String METHOD_NAME = "runCMD";
        Process p = Runtime.getRuntime().exec(cmd);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String readLine = br.readLine();
            StringBuilder builder = new StringBuilder();
            while (readLine != null) {
                readLine = br.readLine();
                builder.append(readLine);
            }

            p.waitFor();
            int i = p.exitValue();
            if (i == 0) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
