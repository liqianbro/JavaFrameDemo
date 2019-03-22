package com.booterror.errordemo.util;

import java.io.File;

/**
 * maven 本地仓库清理类工具类
 * <p>
 * 删除本地maven仓库中的空文件夹
 * 删除本地maven仓库中含有后缀为.lastUpdated的文件的文件夹
 * 删除本地maven仓库中后缀为.jar-in-progress的文件的文件夹
 * <p>
 * Copyright 刘兴华
 *
 * @author 刘兴华
 */
public class MavenRepositoryCleanUtil {
    // 注意：MAVEN_REPO_PATH 的值需要替换成你自己的maven本地仓库地址
    private static final String MAVEN_REPO_PATH = "C:\\Users\\LiQian\\.m2\\repository";
    private static final String[] SUFFIX = {".lastUpdated", "jar-in-progress"};

    /**
     * @param args
     */
    public static void main(String[] args) {
        File mavenRep = new File(MAVEN_REPO_PATH);
        if (!mavenRep.exists()) {
            System.out.println("Maven repos is not exist.");
            return;
        }
        File[] files = mavenRep.listFiles();
        checkAndDeleteFiles(files);
        System.out.println("Clean lastUpdated files and in-progess jar finished.");
    }

    private static boolean checkAndDeleteFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory() == true) {
                if (file.listFiles().length == 0) {
                    // 删除空文件夹
                    file.delete();
                } else {
                    boolean flag = checkAndDeleteFiles(file.listFiles());
                    if (flag) {
                        // 删除文件夹中的文件
                        for (File childFile : file.listFiles()) {
                            childFile.delete();
                        }
                        System.out.println(file.getAbsolutePath());
                        // 删除文件夹
                        file.delete();
                    }
                }
            } else {
                for (int i = 0; i < SUFFIX.length; i++) {
                    if (file.getName().contains(SUFFIX[i])) {
                        System.out.println(file.getName());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}