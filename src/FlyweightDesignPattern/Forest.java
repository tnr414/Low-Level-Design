package FlyweightDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    List<TreeData> treeData = new ArrayList<>();

    public void plantTree(int x, int y, String type, String color, String texture) {
        TreeType treeType = TreeFactory.getTreeType(type, color, texture);
        treeData.add(new TreeData(x, y, treeType));
    }

    public void renderForest() {
        for (TreeData data: treeData) {
            data.treeType.render(data.x, data.y);
        }
    }

    // extrinsic state tree data
    private static class TreeData {
        int x, y;
        TreeType treeType;

        public TreeData(int x, int y, TreeType treeType) {
            this.x = x;
            this.y = y;
            this.treeType = treeType;
        }
    }
}
