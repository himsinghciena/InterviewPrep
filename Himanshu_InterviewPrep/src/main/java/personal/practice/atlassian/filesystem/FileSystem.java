package personal.practice.atlassian.filesystem;

import java.util.HashMap;
import java.util.Map;
class FileSystem {

    Map<String, Integer> fileMap;

    public FileSystem() {
        fileMap = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if(isPathValid(path)){
            fileMap.put(path, value);
            return true;
        }

        return false;
    }

    private boolean isPathValid(String path){
        if(path == null || path.isEmpty() || path.equals("/"))
            return false;

        if(fileMap.containsKey(path))
            return false;

        int lastSlashIndex = path.lastIndexOf("/");

        if(lastSlashIndex > 0){
            return fileMap.containsKey(path.substring(0, path.lastIndexOf("/")));
        }

        return true;
    }

    public int get(String path) {
        return fileMap.getOrDefault(path, -1);
    }

    public static void main(String[] args){
        FileSystem fileSystem = new FileSystem();

        System.out.println("First Input ");
        System.out.println(fileSystem.createPath("/a", 1)); // return true
        System.out.println(fileSystem.get("/a")); // return 1

        System.out.println("Second Input ");
        System.out.println(fileSystem.createPath("/leet", 1)); // return true
        System.out.println(fileSystem.createPath("/leet/code", 2)); // return true
        System.out.println(fileSystem.get("/leet/code")); // return 2
        System.out.println(fileSystem.createPath("/c/d", 1)); // return false because the parent path "/c" doesn't exist.
        System.out.println(fileSystem.get("/c")); // return -1 because this path doesn't exist.



    }
}