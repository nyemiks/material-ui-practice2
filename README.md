
### Development mode

Getting started with material ui by following the youtube course "MUI5 (Material UI) Crash Course"  https://www.youtube.com/watch?v=o1chMISeTC0

The practice exercise was implemented using clojurescript (reagent). Re-frame, pushy and bidi where used for routing.

```
npm install
npx shadow-cljs watch app
```
start a ClojureScript REPL
```
npx shadow-cljs browser-repl
```
### Building for production

```
npx shadow-cljs release app
```
