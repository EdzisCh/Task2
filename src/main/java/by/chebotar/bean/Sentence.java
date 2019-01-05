package by.chebotar.bean;

import by.chebotar.interfaces.TextStructure;
import java.util.ArrayList;
import java.util.List;

public class Sentence extends Paragraph {

  private List<TextStructure> children = new ArrayList<TextStructure>();

  public String getText() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < children.size(); i++) {
      stringBuilder.append(children.get(i).getText()).append(" ");
    }
    return stringBuilder.toString();
  }

  public void setChild(TextStructure child){
    children.add(child);
  }

  public void setChildren(TextStructure... children){
    for (TextStructure child : children) {
      this.children.add(child);
    }
  }

  public boolean removeChildren(TextStructure child){
    if(children.contains(child)){
      children.remove(child);
      return true;
    }
    return false;
  }
}
