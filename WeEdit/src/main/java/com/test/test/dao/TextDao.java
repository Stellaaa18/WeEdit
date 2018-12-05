package com.test.test.dao;

import com.test.test.entity.Text;
import com.test.test.entity.TextComment;
import com.test.test.entity.TextContent;

import java.util.List;

public interface TextDao {
    /**
     * 列出文章信息
     *
     * @return areaList
     */
    List<Text> queryText();
    /**
     * 列出段落信息
     *
     * @return areaList
     */
    List<TextContent> queryTextContent();
    /**
     * 列出评论信息
     *
     * @return areaList
     */
    List<TextComment> queryTextComment();
    /**
     * 根据Id列出具体文章
     *
     * @param textId
     * @return  area
     */
    Text queryTextById(int textId);
    /**
     * 根据Id列出该篇文章段落
     *
     * @param textContentId
     * @return  area
     */
    TextContent queryTextContentById(int textContentId);
    /**
     * 根据Id列出该篇文章段落
     *
     * @param textCommentId
     * @return  area
     */
    TextComment queryTextCommentById(int textCommentId);
    /**
     * 插入一个文本信息text
     *
     * @param text 区域
     * @return
     */
    int insertText(Text text);
    /**
     * 插入一个段落信息text
     *
     * @param textContent
     * @return
     */
    int insertTextContent(TextContent textContent);
    /**
     * 插入一个评价信息text
     *
     * @param textComment
     * @return
     */
    int insertTextComment(TextComment textComment);
    /**
     * 删除某一个文本信息
     *
     * @param textId
     * @return
     */
    int deleteText(int textId);
    /**
     * 删除某一个文本信息
     *
     * @param textCommentId
     * @return
     */
    int deleteTextComment(int textCommentId);
    /**
     * 删除某一个文本信息
     *
     * @param textContentId
     * @return
     */
    int deleteTextContent(int textContentId);
    /**
     * 更新文章信息
     *
     * @param text
     * @return
     */
    int updateText(Text text);
    /**
     * 更新段落信息
     *
     * @param textContent
     * @return
     */
    int updateTextContent(TextContent textContent);
    /**
     * 更新评论信息
     *
     * @param textComment
     * @return
     */
    int updateTextComment(TextComment textComment);
}
