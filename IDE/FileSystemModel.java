package ru.Compiler.IDE;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

class FileSystemModel extends DefaultTreeModel {
    private File root;

    public FileSystemModel(File root) {
        super(new DefaultMutableTreeNode(root.getName()));
        this.root = root;
        loadTree((DefaultMutableTreeNode) getRoot(), root);
    }

    private void loadTree(DefaultMutableTreeNode node, File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(f.getName());
                node.add(child);
                if (f.isDirectory()) {
                    loadTree(child, f);
                }
            }
        }
    }
}

