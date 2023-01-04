



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

 ## web
</br>

>### 🐍 웹 서버 구축
|Python Django|
|:-:|
|<img src="https://user-images.githubusercontent.com/109738563/210552769-69ef8f82-1a35-4b42-bac8-69892a685afb.png">|

**웹부분은 파이썬 Django를 이용하여 서버를 구축하였습니다.**
</br>

>### 🗄️ 데이터베이스(DB)
|My SQL DB|
|:-:|
|<img src="https://user-images.githubusercontent.com/109738563/210556592-fef7c496-374d-4df5-ad2c-b6cf258b39d1.png">|

>**데이터 베이스는 웹과 애플리케이션에서 사용자 정보와 결과 값을 저장하기 위해 DB 서버하나를 두어 원격으로 연동하였습니다.**
</br>

>### 🔄 데이터베이스 연동
|웹 DB 연동|애플리케이션 DB 연동|
|:-:||:-:|
|<img src ="https://user-images.githubusercontent.com/109738563/210557095-efc7e130-7d1f-43be-b96a-df4ae5669bc1.png">|<img src="https://user-images.githubusercontent.com/109738563/210557197-ac798297-182f-4046-a333-4389b765b821.png">|

>**웹과 애플리케이션에 DB 내용이 일치하는 것으로 정상적으로 연동된 결과를 확인하였습니다.**
</br>

>### 💹 웹 대시보드 화면
|웹 대시보드 화면|
|:-:|
|<img src="https://user-images.githubusercontent.com/109738563/210578740-6fb0701c-1c80-4dc9-a7be-af5b9c8216e7.png">|

**웹 대시보드 화면은 Bootstrap의 대시보드 디자인 틀을 사용하였고, DB와 연동하여 저장된 값을 가져오는 기능을 구현하였습니다.
먼저 애플리케이션 사용자 수는 애플리케이션에서 회원가입한 사람의 정보가 DB서버에 저장되면 웹에서는 DB서버에 저장된 사용자의 총 수를 가져오도록 구현하였고, 보이스피싱 탐지 수는 DB서버의 보이스피싱 탐지에 저장된 값의 총 수를 가져와 구현하였으며, 마지막으로 파이썬 기본 기능인 현재 시간을 나타내도록 구현하였습니다.
또한, Django로 구축한 웹서버는 정적으로 구현되기 때문에 자동으로 5초마다 새로고침하는 기능을 프론트엔드로 구현하였습니다.**
</br>

>### 🕵️ 탐지로그 현황
|보이스피싱 탐지 로그 현황|
|:-:|
|<img src="https://user-images.githubusercontent.com/109738563/210580039-80761e68-0dcf-46cb-ad85-da993322f622.png">|

**애플리케이션 부분에서 보이스피싱이 탐지되었을 경우, 탐지된 데이터만 DB서버에 저장을하고 웹 탐지 로그에서는 DB에 저장된 값을 자동으로 읽어오는 기능을 구현하였습니다.**
</br>

>### 🗺️ 보이스피싱 동향
|보이스피싱 동향 차트|
|:-:|
|<img src="https://user-images.githubusercontent.com/109738563/210580803-e011d6c7-1baa-4b2d-8582-a41da07f1a35.png">|

>**웹페이지에 접속하면 연간보이스피싱 동향과 연령별보이스피싱 동향을 한눈에 볼 수 있도록 디자인하였습니다.**
</br>

>### 🤵 애플리케이션 사용자 수
|애플리케이션 사용자 리스트|지역별 사용자 리스트(검색 기능)|
|:-:|:-:|
|<img src="https://user-images.githubusercontent.com/109738563/210578222-07a2550e-5e22-498d-bb6a-f4fd783bcaca.png">|<img src="https://user-images.githubusercontent.com/109738563/210578300-4b34ad97-5e9b-47f6-85f0-4b44f527ac38.png">|

**애플리케이션을 사용하고 있는 사용자의 정보들을 담은 사용자 목록 화면입니다. 또한 검색기능으로 특정한 사용자를 찾을수 있도록 하였습니다.**
</br>








