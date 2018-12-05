package com.test.test.service.impl;


import com.test.test.dao.TextDao;
import com.test.test.entity.Text;
import com.test.test.entity.TextComment;
import com.test.test.entity.TextContent;
import com.test.test.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TextServicelmpl implements TextService {
    @Autowired
    private TextDao textDao;

    @Override
    public List<Text> queryText() {
        return textDao.queryText();
    }

    @Override
    public List<TextContent> queryTextContent() {
        return textDao.queryTextContent();
    }

    @Override
    public List<TextComment> queryTextComment() {
        return textDao.queryTextComment();
    }

    //************************************添加操作的具体事务************************************
    @Transactional
    @Override
    public boolean addText(Text text) {
        if (text.getTextTitle() != null && !"".equals(text.getTextTitle())) {
            text.setTextDate(new Date());
            try {
                int effectedNum = textDao.insertText(text);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息异常: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("信息不能为空!");
        }
    }

    @Override
    public boolean addTextContent(TextContent textContent) {
        if (textContent.getContentAbout()!=null && !"".equals(textContent.getContentAbout())) {
            try {
                int effectedNum = textDao.insertTextContent(textContent);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息异常: "+ e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean addTextComment(TextComment textComment) {
        if (textComment.getCommentContent()!=null && !"".equals(textComment.getCommentContent())) {
            textComment.setCommentDate(new Date());
            try {
                int effectedNum = textDao.insertTextComment(textComment);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息异常: "+ e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }
    //************************************获取的具体事务************************************
    @Override
    public Text getTextById(int textId) {
        return textDao.queryTextById(textId);
    }

    @Override
    public TextContent getTextContentById(int textContentId) {
        return textDao.queryTextContentById(textContentId);
    }

    @Override
    public TextComment getTextCommentById(int textCommentId) {
        return textDao.queryTextCommentById(textCommentId);
    }

    //************************************删除操作的具体事务************************************
    @Transactional
    @Override
    public boolean deleteText(int textId) {
        if (textId > 0) {
            try {
                int effectedNum = textDao.deleteText(textId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除信息异常: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("信息不能为空!");
        }
    }

    @Override
    public boolean deleteTextContent(int textContentId) {
        if (textContentId > 0) {
            try {
                int effectedNum = textDao.deleteTextContent(textContentId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除内容信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除内容信息异常: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("信息内容不能为空!");
        }
    }

    @Override
    public boolean deleteTextComment(int textCommentId) {
        if (textCommentId > 0) {
            try {
                int effectedNum = textDao.deleteTextComment(textCommentId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除评论信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除评论信息异常: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("评论信息不能为空!");
        }
    }

    //************************************更新操作的具体事务************************************
    @Transactional
    @Override
    public boolean modifyText(Text text) {
        if(text.getTextId()!= null && text.getTextId()>0)
        {
            text.setTextUpdateDate(new Date());
            try {
                int effectedNum = textDao.updateText(text);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新文章信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新文章信息异常: " + e.getMessage());
            }
        }else{
            throw new RuntimeException("文章信息不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean modifyTextContent(TextContent textContent) {
        if(textContent.getContentId()!= null && textContent.getContentId()>0)
        {
            textContent.setContentLast(textContent.getContentAbout());
            try {
                int effectedNum = textDao.updateTextContent(textContent);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新段落信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新段落信息异常: " + e.getMessage());
            }
        }else{
            throw new RuntimeException("段落信息不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean modifyTextComment(TextComment textComment) {
        if(textComment.getCommentId()!= null && textComment.getCommentId()>0)
        {
            textComment.setCommentDate(new Date());
            try {
                int effectedNum = textDao.updateTextComment(textComment);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新评价信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新评价信息异常: " + e.getMessage());
            }
        }else{
            throw new RuntimeException("评价信息不能为空!");
        }
    }
}
