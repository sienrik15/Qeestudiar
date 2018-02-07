package com.example.user.qeestudiar.models;



import java.util.List;

/**
 * Created by User on 29/11/2017.
 */

public class Mentor {

    private String id;

    private String name;

    private String career;

    private String specialization;

    private String socialMedia;

    private String linkProject;

    private String photoPath;

    private Object about;

    private List<Experience> experiences = null;

    private Object questionAboutDecision;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getLinkProject() {
        return linkProject;
    }

    public void setLinkProject(String linkProject) {
        this.linkProject = linkProject;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public Object getQuestionAboutDecision() {
        return questionAboutDecision;
    }

    public void setQuestionAboutDecision(Object questionAboutDecision) {
        this.questionAboutDecision = questionAboutDecision;
    }

}
