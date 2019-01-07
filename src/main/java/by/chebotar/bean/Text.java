package by.chebotar.bean;

import by.chebotar.interfaces.TextStructure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text implements TextStructure {

  private List<TextStructure> children = new ArrayList<TextStructure>();

  public List<TextStructure> getChildren() {
    return children;
  }

  public TextStructure getLastChild(){
    return children.get(children.size()-1);
  }

  public String getText() {
    StringBuilder stringBuilder = new StringBuilder();
    for (TextStructure child : children) {
      stringBuilder.append(child.getText());
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
