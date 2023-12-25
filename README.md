# Affective State Recognition Using Consumer Grade EEG



Independent Research Project CS-400 Special Problems

By
Gabriel Hervias
December 2023

Advised by Dr. Javier Gonzalez-Sanchez

Introduction

Topic: Student psychological well-being during high concentration academic activities.

The purpose of this project is to build a software tool that will allow research to be done with the goal of learning more about student’s psychological well-being during high concentration academic tasks. The software tool is intended to be a proof of concept application that is able to gather sensor data from a EEG headset to track the aﬀective state of a student to gain insights to the correlation between those aﬀective states and the performance of the student. Specifically, the EEG headset we use is called the EMOTIV Insight 2.0. This is a consumer- grade EEG sold by EMOTIV.

The intended user for this sort of application would be researchers interested in studying the aﬀective state of students engaged in an environment that requires them to perform a task that requires a high level of concentration. The particular demographic I had in mind when creating this application was undergrad, engineering students. However, there is no reason to limit the participants of a research project to only this demographic.

From personal experience, it seems that many students struggle with emotional regulation during tasks related to courses they are enrolled in. To learn more about how the tendencies of individual students’ aﬀective state while actually carrying out the tasks might open up opportunities to make students more aware about their own well-being, help educators recognize where students may be struggling, and potentially allow for conclusions to be drawn about how the aﬀective state of a student is correlated with their academic performance.


Goals and Timeline

This project was started in week 2 of Fall quarter 2023. From the start, the following items were my goals for the project:

Learn about aﬀect, the PAD model, and how the Insight 2.0 measures aﬀect.
Become familiar with the Insight 2.0 EEG headset.
Build an application that records aﬀect and student performance during a set of questions.
Test the application using the Insight 2.0 EEG headset and a group of students.


Due to time constraints, only items 1-3 were able to be completed. In the following pages of this report, I will detail what I have learned in the past 8 weeks while working towards completing this project.

Background

Technologies/Methods

Insight 2.0 and EEG

The Emotiv Insight 2.0 is an mobile electroencephalogram (EEG) headset. EEG is a method used to measure electrical activity in the brain using small metal disks attached to the scalp. EEG detects spontaneous electrical activity, which have been shown to represent the changes between the interior and external of membranes connecting the junctions through which a neuron’s signals can be sent to other neurons as well as non-neuronal cells.
The Insight 2.0 detects aﬀective state using a normative database built from experimental datasets collected from volunteers . The data is proprietary and unpublished. The detection suite measures 6 metrics: Stress, Engagement, Interest, Excitement, Focus, and Relaxation.
There is a standard method called the “International 10-20 system” which describes the location of electrodes on the scape for an EEG exam. The Insight headset uses this method.
One term that I will use later in this report is “event related potential”, or ERP. This refers to the measured brain response that is the direct result of a specific sensory, cognitive, or motor event. In this case, ERP could be the event of completing a task, incorrectly answering a question, or starting a new task that is very diﬀerent from the previous one.



Readings from the Insight 2.0 EEG headset using the EmotivPRO software.
PAD Model

The Pleasure-Arousal-Dominance model (PAD), is a conceptual framework used to understanding and measure aﬀective states. The model was proposed by Albert Mehrabian in 1996 and is based on three primary dimensions: Pleasure, Arousal, and Dominance. It plots aﬀective state in this three-dimensional space based on the intensity of each of the individual axes. The goal of this model is to allow for a more nuanced and comprehensive understanding of emotional experiences compared to simpler models.

One such simpler model is the discrete model, which viewed emotions as finite and distinct categories, focusing on strong emotions like disgust, sadness, happiness, fear, anger, and surprise. In contrast, the continuous dimensional model acknowledges the continuous nature of aﬀective states.



Pleasure-Arousal-Dominance dimensional model.

The PAD model is one of the metrics measured and recorded by the software tool in order to determine the aﬀective state of a student.
Java Tooling

The application is mainly based around the JavaFX GUI library built for Java. The “Scene Builder” is a graphical interface for JavaFX that allows you to visually construct a GUI. It was used to style the individual screens shown in the application.

Screen capture of Scene Builder, a commonly used software to visually layout JavaFX visual components.




The JavaFX GUI library contains a stage (the window), multiple scenes (what appears on the window at any given moment) and nodes (the visual components on the scene such as a button, an input field, etc.). Scenes are controlled by “Controller” classes, which contain the logic behind the frontend components.

Related Work
EEG Based Evaluation of Examination Stress and Test Anxiety Among College Students

This study explores the evaluation of examination stress and test anxiety among college students using EEG. The researchers assessed cognitive stress in students before and after examinations. EEG signals were recorded under two conditions: 12 minutes before the
examination and 3 minutes after the examination, from 14 subjects with electrodes placed using a wireless Enobio device.

The experimental results indicate that memory and concentration were higher before examinations, suggesting elevated stress levels in the adolescent group during this period. In terms of gender comparison, the study suggests that after examinations, male students exhibited lower heart rate indices than females, implying better stress control in males in similar stress situations.

Gender based diﬀerences is an important are an important consideration that can be taken when performing research using this software application. Additionally, the measurement of Aﬀective state pre and post examination is something that the software application does not do, but could be modified to implement in the future.




Automated classification of EEG signals for predicting students' cognitive state during learning

This study explores the feasibility of using EEG recordings from oﬀ-the-shelf wearable devices to automatically classify cognitive states, such as concentration and comprehension levels, during reading and question-answering tasks in distance learning applications. The research demonstrates that EEG data eﬀectively predicts whether a student is attentive or distracted, as well as their reading speed. However, the study highlights that predicting correct answers to questions related to reading materials requires consideration of additional factors, such as students' background knowledge.

This study is very similar to what I would hope to be achieved with the software application. However, there are some questions that are not asked in this study that I envision being researched in a future study. Namely:

How can the aﬀective state be modulated through a period of work using commonly used study techniques?
What correlations can be found between the depth of work being performed and the aﬀective state of students?
What correlations can be found between the aﬀective state of students and the outcomes of their performance/the quality of their results?

EEG-Based Tool for Prediction of University Students’ Cognitive Performance in the Classroom

The study presents a neuroengineering-based machine learning tool designed to predict university students' performance under diﬀerent learning modalities, specifically text and video. EEG signals were recorded during learning tasks, and the results indicate that the video group outperformed the text group. The analysis identified relevant EEG features, including the (theta/ alpha) ratio and delta power, associated with mental fatigue and drowsiness. The developed machine learning tool achieved 85% accuracy in predicting learning performance and correctly identified the video group as the more eﬃcient modality. The study emphasizes the potential of EEG measurements as biomarkers for predicting cognitive traits and evaluating teaching modalities in the educational field.

This study is significant because it further validates the usefulness in using EEG to evaluate cognitive factors relevant to students. I would like to see future studies build on top of the idea of predicting academic performance by attempting to study the modulation of aﬀective state with the goal of improving academic performance.

Project Features
Main Appealing Properties

The main appealing property of this application is the use case it provides for a researcher. Using this application, a researcher is able to customize, start, and record a testing session that puts a student through any number of questions/tasks. The aﬀective state as measured through the Insight 2.0 EEG is recorded and mapped onto the events that occur during the testing session.


Main Functional Requirements

Initialization of a session of tasks in which


Save file example. Top to bottom: Header, question history, affect data, PAD data.

student answer attempts and aﬀective state are recorded and timestamped.
Recorded aﬀective state data includes both PAD data as well as data directly from the EEG headset.
File save name includes time of test start and the student’s name.


Customizable session settings
Length of session can be set before starting the session
The content and types of tasks that will be shown can be edited prior to a session
Student name can be set before starting


Types of tasks
There are currently two types of tasks (math and coding) that show up diﬀerently on the testing screen. More can be added to fit the needs of a researcher (multiple choice, visual matching, etc.)











Session setup page.
Coding questions
One type of task that can be presented to students is a coding task, where an input box implementing a code syntax highlighter allows students to write a piece of code. The application will run that code to evaluate whether or not it meets the requirements for the completion of that task. For example, a student may be asked to write a function ‘double(x)’ which takes in a number value x and returns 2*x. Then, the application will then attempt to call and test that function and determine if the results are correct.





Security

Math Task

Coding task


In terms of security, there are no checks done on the coding questions to ensure they are safe for the system they are being run on. This is something that I would like to learn about and work on in the future.


User Stories (requirements)
Completed user stories:

As a researcher, I want each run of tasks to save a file with results to be able to review later.

As a researcher, I want to be able to control a variety of settings for what tasks are presented to a student, how long the student has, and toggling of diﬀerent popups and screens.
As a researcher, I want some sort of indication of if the EEG headset is recording data.

As a student, I should be prompted with a set of tasks that have a clear objective, and relevant information (timer, description, submission, etc.)
System Design
Functional Components

The application is split up into 4 main modules, two of which were copied over from a previous project for the connecting the EEG headset.

.GUI
This module contains the main function which is responsible for starting the JavaFX application, creating a session, and calling the BCI module to connect to the Insight 2.0 EEG. This module contains the logic that JavaFX uses to manipulate the user interface.

.TASKS
This module is responsible for all the logic for sessions. This includes maintaining timer state, the creation of diﬀerent types of questions, question answer validation, and session start, stop, and status functions.

.DATA
This module was copied from the SURP COBOT project. It is responsible for reading and interpreting the data received from the EEG headset.


.EMOTIV
This module was also copied from a previous project. It handles the network connection with the EEG device.






Code Architecture Diagram for Software Tool

Experiments


Intended use

The intended use of this application is as follows:

Researcher sets up tasks, making decisions such as task diﬃculty, session length (time and number of tasks), and what types of tasks will be presented to students. The researcher should keep in mind how context switches, or ERP, between diﬀerent types of questions will play into the session, how they want diﬃculty to be modulated, among other things.
Researcher puts a student through a session, monitoring their progress.
Researcher examines the results of the session, and asks questions such as:
Does a highly stressed performance correlate with a poor performance for an individual student?
Does being in a deeply meditative/concentrated state correlate with a good performance?
Do students with higher stress tend to score better?
How does the performance of a student who experiences changes in stress levels throughout the duration of a testing session compare with a student who experiences a steady stress level?
How does the depth of concentration an individual student experiences during a session correlate to how that students feel after a test/feel about the test?

Conclusions and Future Work

Conclusion
My initial vision when starting this project was to test the eﬀectiveness of software tools that guided students through a session of deep work. These tools would implement any of a number of commonly known study techniques, such as a Pomodoro timer, guided meditation, etc. I would like to see in the future the use of this application to study the correlation between the use of these tools and students aﬀective state.


Uncompleted Stretch Goals

VISUALIZATION OF TEST RESULTS
One thing that I was not able to get to that I would like to see done in the future is some sort of visualization screen of the test results. This could look something like a scrollable timeline graphing a students aﬀective state mapped over markers indicating events within a session (task answered incorrectly, task completed, etc.).

AFFECT VALIDATION
Another feature that I would like to see implemented is some sort of popup that occurs at pre- determined points within a session that prompts a student to answer questions about their perceived aﬀective state. This could prove useful in validating the results from the EEG headset.

INPUT SANITIZATION
The coding task, in its current implementation, does not contain any sort of input sanitization. This is vulnerability has the potential to put the machine the application is running on at risk. Currently, it can be mitigated by having a someone supervise a student as they are using the application.

TESTING SOFTWARE WITH STUDENTS
Due to time constraints, I was not able to actually use the testing with students. In the future, I would like to see the software being used to track the aﬀective state of students through a battery of tasks. I would like to see how the results from the software stack up against the subjective experiences of the students.

References

2022-06-26, P. (2022, June 26). JavaFX Documentation Project. https://fxdocs.github.io/ docs/html5/
EMOTIV Knowledge base. EMOTIV. (2018, December 20). https://www.emotiv.com/ knowledge-base/
Gonzalez-Sanchez, J., Baydogan, M., Chavez-Echeagaray, M. E., Atkinson, R. K., & Burleson, W. (2017). Affect measurement: A roadmap through approaches, technologies, and data analysis. Emotions and Affect in Human Factors and Human-Computer Interaction, 255–288. https://doi.org/10.1016/
b978-0-12-801851-4.00011-2
Liu, X., Tan, P.-N., Liu, L., & Simske, S. J. (2017). Automated classification of EEG signals for predicting students’ cognitive state during learning. Proceedings of the International Conference on Web Intelligence. https://doi.org/ 10.1145/3106426.3106453
Rajendran, V. G., Jayalalitha, S., & Adalarasu, K. (2022). EEG based evaluation of examination stress and test anxiety among college students. IRBM, 43(5), 349–
361. https://doi.org/10.1016/j.irbm.2021.06.011
Ramírez-Moreno, M. A., Díaz-Padilla, M., Valenzuela-Gómez, K. D., Vargas-Martínez, A., Tudón-Martínez, J. C., Morales-Menendez, R., Ramírez-Mendoza, R. A., Pérez- Henríquez, B. L., & Lozoya-Santos, J. de. (2021). EEG-based tool for prediction of university students’ cognitive performance in the classroom. Brain Sciences, 11(6), 698. https://doi.org/10.3390/brainsci11060698
