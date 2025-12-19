# 🥗 HealthyMe: Smart BMI Calculator & Health Tracker

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![UI/UX](https://img.shields.io/badge/UI%2FUX-Animations-ff69b4?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

## 📱 Project Overview
**HealthyMe** is a modern, native Android application designed to help users monitor their physical health through precise Body Mass Index (BMI) calculation.

Unlike standard calculators, HealthyMe focuses on **User Experience (UX)** using smooth entrance animations and dynamic color-coding. It interprets the BMI result to provide **actionable health advice**, helping users understand whether they are underweight, normal, or need to manage their weight.

## ✨ Key Features

### 🧠 Smart Calculation Logic
* **Instant Accuracy:** precise BMI calculation based on height and weight inputs.
* **Categorization Engine:** Automatically classifies results into:
    * 🔵 *Underweight*
    * 🟢 *Normal Weight*
    * 🟡 *Overweight*
    * 🔴 *Obese*
* **Health Insights:** Provides specific textual advice based on the calculated category (e.g., dietary tips for underweight, exercise for overweight).

### 🎨 Interactive UI & UX
* **Dynamic Theming:** The result screen changes color themes (Green, Yellow, Red) to visually represent the health status.
* **Visual Scale:** A dynamic progress bar that positions the user's BMI on a visual scale.
* **Smooth Animations:** Custom `DecelerateInterpolator` animations for UI elements (Cards, Buttons, and Text) to create a polished feel.
* **Gradient Backgrounds:** Programmatic implementation of `GradientDrawable` for modern card aesthetics.

---

## 🛠️ Tech Stack
Built with modern Android development standards:

<p align="left">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=android,kotlin,java,git,idea" />
  </a>
</p>

| Component | Technology |
| :--- | :--- |
| **Language** | Kotlin (100%) |
| **UI Toolkit** | XML Layouts with ViewBinding |
| **Architecture** | Activity-based with Intent passing |
| **Visuals** | Custom Animations & Drawable Graphics |

## 📸 Screenshots

| Input Screen | Result Screen (Normal) | Result Screen (Warning) |
| :---: | :---: | :---: |
| ![WhatsApp Image 2025-12-19 at 11 21 52_1d08c1b7](https://github.com/user-attachments/assets/e51af659-b313-4ef9-8563-bc67a4687dfc)|![WhatsApp Image 2025-12-19 at 11 21 52_9f00cad2](https://github.com/user-attachments/assets/ff2df0ee-05dc-4387-b7cc-b16b19bb0483)|![WhatsApp Image 2025-12-19 at 11 21 52_1b8572f0](https://github.com/user-attachments/assets/048d640b-ae30-4a7a-b433-ac1b1eccc31d)|

> *Note: The app features entrance animations that fade and slide elements into view for a premium user experience.*

## 🚀 How to Run
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/ahmed-magdy-gitt/HealthyMe-BMI.git](https://github.com/ahmed-magdy-gitt/HealthyMe-BMI.git)
    ```
2.  **Open in Android Studio:**
    * File -> Open -> Select the project folder.
    * Let Gradle sync complete.
3.  **Run:**
    * Connect an Android Device or Emulator.
    * Click the green **Run** button (Shift + F10).

---
*Developed by Ahmed Magdy | 2025*
*Android Developer Portfolio*
