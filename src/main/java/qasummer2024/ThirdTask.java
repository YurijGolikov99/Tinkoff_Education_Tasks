package qasummer2024;

/*
Задача 3
Понятная файловая система — залог успеха любой операционной системы. К сожалению, не каждая файловая система может похвастаться таким свойством. Но, как говорится, если что-то хочешь сделать хорошо — сделай это сам! Хочется иметь удобное для просмотра представление директорий, чтобы можно было видеть, какие директории в какие вложены.
Для этого требуется по списку директорий вывести их перечисление в алфавитном порядке. При этом вложенные директории должны быть выведены с отступом на два пробела больше, чем у родительской.
Формат входных данных
В первой строке дано число n — количество директорий (1 ≤ n ≤ 10^5). В следующих n строках по одному в строке заданы абсолютные пути ко всем директориям, каждый абсолютный путь — это последовательность вложенных папок, начиная с корневой, разделенная символами "/".
Гарантируется, что первая директория во всех путях одинаковая и имеет непустое имя. Имена всех директорий состоят из маленьких латинских букв и имеют длину не более 10. Гарантируется, что если директория выведена, то выведены и все, в которые она вложена.
Формат выходных данных
Выведите перечисление всех директорий, в котором все директории внутри одной упорядочены по алфавиту, вложенные идут сразу после родительской и имеют отступ на два пробела больше, чем у нее.
Примеры данных
Пример 1
Ввод
6
root/a
root/a/b
root/c/x
root/a/b/c
root
root/c
Вывод
root
 a
  b
   c
 c
  x
Пример 2
Ввод
4
a/b/c/d
a/b
a/b/c
a
Вывод
a
 b
  c
   d
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdTask {

    static class Directory {
        String name;
        List<Directory> children;

        public Directory(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public void addChild(Directory child) {
            children.add(child);
        }

        public List<Directory> getChildren() {
            return children;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1 || n > Math.pow(10, 5)) {
            System.out.println("Число директорий должно быть в диапазоне от 1 до 100000.");
            return;
        }
        scanner.nextLine();

        Directory root = null;

        for (int i = 0; i < n; i++) {
            String path = scanner.nextLine();
            String[] dirs = path.split("/");
            if (root == null) {
                root = new Directory(dirs[0]);
            }
            Directory currentDir = root;
            for (int j = (root.getName().equals(dirs[0]) ? 1 : 0); j < dirs.length; j++) {
                String dirName = dirs[j];
                Directory childDir = null;
                for (Directory child : currentDir.getChildren()) {
                    if (child.getName().equals(dirName)) {
                        childDir = child;
                        break;
                    }
                }
                if (childDir == null) {
                    childDir = new Directory(dirName);
                    currentDir.addChild(childDir);
                }
                currentDir = childDir;
            }
        }

        printDirectories(root, 0);
    }

    public static void printDirectories(Directory dir, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        sb.append(dir.getName());
        System.out.println(sb.toString());
        for (Directory child : dir.getChildren()) {
            printDirectories(child, indent + 1);
        }
    }
}
