package by.chebotar.bean;

import by.chebotar.interfaces.TextStructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence extends Text {

  private List<TextStructure> children = new ArrayList<TextStructure>();

  public List<TextStructure> getChildren() {
    return children;
  }

  public TextStructure getChild(int index) {
    return children.get(index);
  }

  public String getText() {
    StringBuilder stringBuilder = new StringBuilder();
    for (TextStructure child : children) {
      stringBuilder.append(child.getText()).append(" ");
    }
    return stringBuilder.toString();
  }

  public void setChild(TextStructure child){
    children.add(child);
  }

  public void setChildren(TextStructure... children){
    this.children.addAll(Arrays.asList(children));
  }

  public boolean removeChildren(TextStructure child){
    if(children.contains(child)){
      children.remove(child);
      return true;
    }
    return false;
  }
}
