
# react-native-google-pay-tez - Android Only

[![npm](https://img.shields.io/npm/l/express.svg)]()

[![NPM](https://nodei.co/npm/react-native-google-pay-tez.png?downloads=true)](https://nodei.co/npm/react-native-google-pay-tez/)

## Getting started

`$ npm install react-native-google-pay-tez --save`

### Mostly automatic installation

`$ react-native link react-native-google-pay-tez`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.mahak.RNGooglePayTezPackage;` to the imports at the top of the file
  - Add `new RNGooglePayTezPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-google-pay-tez'
  	project(':react-native-google-pay-tez').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-google-pay-tez/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':react-native-google-pay-tez')
  	```

#### Request Parameters (All should be in String format only)
```
1. scheme - `Use 'upi' (Don't change this)`
2. authority - `Use 'pay' (Don't change this)`
3. merchantUPI - `Your verified merchant UPI though Google Pay for Business team`
4. merchantName - `Your verified merchant name though Google Pay for Business team`
4. merchantCode - `Your verified merchant code provided though Google Pay for Business team`
5. transactionId - `A unique transaction id identify . Make sure to provide unique key everytime`
6. transactionNote - `Message you want to display on Google Pay (Tez) App while transaction`
7. transactionAmount - `Transaction amount, eg "1.00" format`
8. transactionCurrency - `Use 'INR' (Don't change this)`
9. merchantURL - `Your verified merchant url through Google Pay Business team`
```

#### Response Parameters (In JSON)
```
1. validationError - `True in case any of validation failed, else false`
2. hasAppInstalled - `True in app is available and installed in your android device else false`
3. message - `Message for all states`
4. transactionStatus - `Transaction status after launching of Google Pay (Tez) app`
5. googlePayTezTxnId - `App transaction id provided by google`
6. responseCode - `Response code based on app actions`
```

## Usage
```javascript
import RNGooglePayTez from 'react-native-google-pay-tez';

_handleInitGooglePay = (googlePayParams) => {
    const {
        scheme,
        authority,
        merchantUPI,
        merchantName,
        merchantCode,
        transactionId,
        transactionNote,
        transactionAmount,
        transactionCurrency,
        merchantURL
    } = googlePayParams;

    // Dispatch Google Pay (Tez) Call 
    RNGooglePayTez.GooglePayInit(
        scheme,
        authority,
        merchantUPI,
        merchantName,
        merchantCode,
        transactionId,
        transactionNote,
        transactionAmount,
        transactionCurrency,
        merchantURL, (response) => { /* Transaction Response */ });
}
```

### If you face any difficulty or having any suggestion, feel free post your review on repository