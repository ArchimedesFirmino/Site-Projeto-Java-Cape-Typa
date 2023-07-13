// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  firebase: {
    projectId: 'cape-typa',
    appId: '1:119190985175:web:6cc29338653cefffd75392',
    storageBucket: 'cape-typa.appspot.com',
    apiKey: 'AIzaSyDiHQ3tRRe4hj84LtVyOgYSRvAP1iTsbT0',
    authDomain: 'cape-typa.firebaseapp.com',
    messagingSenderId: '119190985175',
  },
  production: false,
  siteName: 'Çape-Typa',
  apiBaseURL: 'http://localhost:8080',
  authMethod: 'redirect'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
