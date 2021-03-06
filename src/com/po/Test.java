package com.po;

public class Test {
    private Integer testId;
    private String userId;
    private String testName;
    private String subjectNo;
    private String questionType;
    private String questionId;
    private String questionContent;
    private String answer;
    private String setGrade;

    private String selectA;
    private String selectB;
    private String selectC;
    private String selectD;

    private String subjectName;

    public Test() {
    }

    public Test(String userId, String testName, String subjectNo, String questionType, String questionId, String questionContent, String setGrade, String selectA, String selectB, String selectC, String selectD, String subjectName) {
        this.userId = userId;
        this.testName = testName;
        this.subjectNo = subjectNo;
        this.questionType = questionType;
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.setGrade = setGrade;
        this.selectA = selectA;
        this.selectB = selectB;
        this.selectC = selectC;
        this.selectD = selectD;
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSetGrade() {
        return setGrade;
    }

    public void setSetGrade(String setGrade) {
        this.setGrade = setGrade;
    }

    public String getSelectA() {
        return selectA;
    }

    public void setSelectA(String selectA) {
        this.selectA = selectA;
    }

    public String getSelectB() {
        return selectB;
    }

    public void setSelectB(String selectB) {
        this.selectB = selectB;
    }

    public String getSelectC() {
        return selectC;
    }

    public void setSelectC(String selectC) {
        this.selectC = selectC;
    }

    public String getSelectD() {
        return selectD;
    }

    public void setSelectD(String selectD) {
        this.selectD = selectD;
    }
}
