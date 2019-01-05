package by.chebotar.interfaces;

public interface TextParser<T> {

  T parse(String token);
  TextParser<T> linkWith(TextParser<T> next);
}
