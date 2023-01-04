



# 🥉 Voice_phishing_detection
### NET 챌린지 캠프 시즌9에 참여했던 프로젝트로 은상을 수상하였습니다.
![image](https://user-images.githubusercontent.com/68285922/208034326-856ac2ba-a42c-487c-8da4-89c479f9acb0.png)
</br>

# 💻 개요
### 보이스피싱을 탐지하는 앱입니다. 총 6명의 팀원이 알고리즘, 웹, 앱 분야로 나누어서 진행하였습니다.

### 위 코드는 안드로이드 앱 코드입니다.

### 통합적인 전화관리 앱으로 보이스피싱 탐지 뿐만 아니라 여러 부가적인 요소들도 구현하였습니다.

</br>

# :laughing: 팀원

||강민지|김희연|김종원|박성윤|고수완|이준권|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
||<img src = "https://user-images.githubusercontent.com/68285922/208907629-744a988b-1a7d-48dd-a0c5-0d42d952235d.png" width="100" height="100">|<img src = "https://user-images.githubusercontent.com/68285922/209243492-e151b093-6bf0-4385-87ad-c0fc5fd8c898.png" width = "100" height="100">|<img src="https://user-images.githubusercontent.com/68285922/208908521-ba37bd9b-9f05-4477-ba27-944f88f6054d.png" width="100" height="100">|<img src="https://user-images.githubusercontent.com/68285922/208908302-c997a2d7-c4f1-47d4-a500-b872edba73b7.png" width="100" height="100">|<img src="https://user-images.githubusercontent.com/68285922/209243694-6161fec7-84d0-4164-88ff-cab479ed838a.png" width="100" height="100">|<img src="https://user-images.githubusercontent.com/68285922/209243759-781ed65b-3a4f-42cd-b081-d249f8b3c103.png" width="100" height="100">|
||[@Kminzzi](https://github.com/Kminzzi)|[@ralgmld](https://github.com/ralgmld)|[@Gomjong](https://github.com/Gomjong)|[@Seongyoon1137](https://github.com/Seongyoon1137)|[@baegofa](https://github.com/baegofa)|[@kwonL57](https://github.com/kwonL57)
|분야|Application|Application|Machine Learning & Algorithm |Machine Learning & Algorithm |Web|Web




</br>

# :paperclip: 기능
</br>

 ## Application
</br>

> #### :email: 회원가입 
> 
|로그인|회원가입|
|:-:|:-:|
|<img src="https://user-images.githubusercontent.com/68285922/209245302-0f7805a7-a75f-4ff6-811a-c2fc244a959d.png" witdh=250 height="500">|<img src="https://user-images.githubusercontent.com/68285922/209245607-51f2bdbc-e520-4db3-97f9-58bb57b3e496.png" width=250 height="500">
#### 입력된 유저 정보는 MySQL에 저장됩니다.
<br/>

> #### :iphone: 전화
|전화번호 입력|전화|
|:-:|:-:|
|<img src="https://user-images.githubusercontent.com/68285922/209246022-340a0118-3c85-40b7-ab84-f71aca160086.png" witdh=250 height="500">|<img src="https://user-images.githubusercontent.com/68285922/209246027-b68e5fda-e1f6-4a0f-b74c-8c2667a5dd8e.png" width=250 height="500">
#### 앱에서 전화번호를 입력하면 전화를 걸 수 있도록 설정하였습니다.

</br>

> #### :pencil: STT(Spech To Text)
|전화번호 입력|전화|
|:-:|:-:|
|<img src="https://user-images.githubusercontent.com/68285922/209246254-8119281d-cde0-44a4-903f-edd2061d4b4a.png" witdh=250 height="500">|<img src="https://user-images.githubusercontent.com/68285922/209246259-9872d753-b373-4503-b6a3-c687f92c6f5c.png" width=250 height="500">
#### 음성인식 시작을 터치하면 음성을 텍스트로 변환합니다.


</br>

> #### :file_folder: 연락처 및 마이페이지
|연락처|마이페이지|
|:-:|:-:|
|<img src="https://user-images.githubusercontent.com/68285922/209247467-9c74b55e-7a5f-4113-88f9-96e1b9e10e12.png" witdh=250 height="500">|<img src="https://user-images.githubusercontent.com/68285922/209246625-3dd82793-1c09-4e1d-88e1-989c9a300c63.png" width=250 height="500">
#### 핸드폰에 저장된 연락처를 불러옵니다. 위 사진에서는 개인 정보가 포함되어 있기 때문에 블러처리 하였습니다. 

#### 마이페이지에서는 로그인된 정보를 기반으로 정보를 불러옵니다.

</br>

> #### :bomb: 보이스피싱 탐지
|탐지|탐지 x|
|:-:|:-:|
|<img src="https://user-images.githubusercontent.com/68285922/209246986-e9e81f01-28ae-4754-b124-33816c75283c.png" witdh=250 height="100">|<img src="https://user-images.githubusercontent.com/68285922/209246988-df965f02-0636-48dc-91b5-40454daa2f9a.png" width=250 height="100">

#### STT된 결과물을 알고리즘 탐지 서버로 전송한 후, 텍스트를 기반으로 보이스피싱 탐지 알고리즘이 작동하여 보이스피싱 결과를 출력합니다. 
#### 앱에서는 그 결과를 가져와 유저의 앱에서 보이스피싱 탐지 결과 여부를 출력합니다.

web 수정중
