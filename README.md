# Fetch Rewards Data Fetcher

## 📌 Overview
This is a native **Android app** built in **Kotlin** that retrieves data from the following API:  
[Fetch Rewards Data](https://fetch-hiring.s3.amazonaws.com/hiring.json).  
It processes and displays the data in a structured, easy-to-read format.

## 🎯 Functionality 
- Fetches data from the API
- Groups items by `listId`
- Sorts items first by `listId`, then numerically by `name`
- Filters out items with blank or null names
- Displays `listId` as section headers

## 📷 Screenshot
<img width="472" alt="Screenshot 2025-03-01 at 3 30 42 PM" src="https://github.com/user-attachments/assets/6651571d-3a9a-4bf2-971d-47dd397105a5" />

## 🚀 Setup Instructions

### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/yourusername/FetchRewardsApp.git
cd FetchRewardsApp
```

### **1️⃣ Open in Android Studio**
```sh
Open Android Studio
Select "Open an Existing Project"
Navigate to the cloned folder and open it
``` 

### **1️⃣ Run the App**
```sh
Connect an emulator or a physical Android device
Click Run ▶️ in Android Studio
``` 

## Dependencies
| **Libraries**  | **Purpose**    |
|----------------|----------------|
| Retrofit       | API calls      |
| Gson           | JSON parsing   |
| RecyclerView   | List display   |


## Sorting Logic
Data is sorted numerically to avoid string-based sorting issues. 

## Contact 
For questions or suggestions, reach out at:
School Email: sgnayak2@illinois.edu
Personal Email: sauravnayak51@gmail.com 
Phone: +1 (217)255-0581

