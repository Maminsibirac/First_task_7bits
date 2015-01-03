package ru.omsu.base.conditions;

public class Conditions {
    private boolean code;
    private boolean stringSingleQuotes;
    private boolean stringDoubleQuotes;
    private boolean commentsInline;
    private boolean commentsBlock;
    private static boolean createFlag = true;
    private static Conditions conditions;

    private Conditions() {
        code = true;
        stringSingleQuotes = false;
        stringDoubleQuotes = false;
        commentsInline = false;
        commentsBlock = false;
    }

    public static Conditions onCreate() {
        if(createFlag) {
            createFlag = false;
            return conditions = new Conditions();
        } else {
            return conditions;
        }
    }

    public boolean isCode() {
        return code;
    }

    public boolean isStringSingleQuotes() {
        return stringSingleQuotes;
    }

    public boolean isStringDoubleQuotes() {
        return stringDoubleQuotes;
    }

    public boolean isInlineComments() {
        return commentsInline;
    }

    public boolean isBlockComments() {
        return commentsBlock;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public void setStringSingleQuotes(boolean stringSingleQuotes) {
        this.stringSingleQuotes = stringSingleQuotes;
    }

    public void setStringDoubleQuotes(boolean stringDoubleQuotes) {
        this.stringDoubleQuotes = stringDoubleQuotes;
    }

    public void setInlineComments(boolean commentsInline) {
        this.commentsInline = commentsInline;
    }

    public void setBlockComments(boolean commentsBlock) {
        this.commentsBlock = commentsBlock;
    }
}
