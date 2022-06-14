# ExchangeRateRestApi
Rest api service that accesses the exchange rate service and displays a gif depending on the change in the exchange rate against <b>USD</b> over the past two days

# Detailed description
Make a request to the service.  
Where to pass the currency code in the parameters.  
Example:  
![image](https://user-images.githubusercontent.com/67160882/173668591-69657bed-ed08-419e-9e17-bd27b2abf47d.png)

# Stack
* Spring Boot
* Gradle
* Feign

# Endpoints

- api/compareExchangeRates?currency=rub - takes a currency code as a parameter  
returns gif depending on the USD exchange rate

example: http://localhost:8081/api/compareExchangeRates?currency=rub

# How to start

* Clone the repository  
git clone https://github.com/Kpojluku/ExchangeRateRestApi.git
* Perform the command  
  ./gradlew build
* Build the docker image  
docker image build -t exchange_rate_app .
* run the docker container  
docker run -p 8081:8081 exchange_rate_app