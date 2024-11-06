# caumond-resume

A [re-frame](https://github.com/day8/re-frame) application designed to share my resume.

## Goal

This website embeds my resume to promote sasu caumond's work.

## Getting Started

Before anything else, run `bb doctor` to check if your environment is ready to run with the website.

Run 

``` clojure
bb doctor
npm install
```

### Local environment

After having copied a local copy of the repository on your computer, go to the directory and launch in two separate threads:

```clojure
bb repl-clj
bb repl-cljs
```

or directly to call both (but logs would be mixed up):

``` clojure
bb env-dev
```

It starts locally a webserver on port `8080`, a clj repl on `8000`, a cljs repl on `8787`.

Then, any modification in the cljs, or html code will be automagically sent to local web server.

### Production 

A production like environment could be build and pushed to clever cloud with:

``` clojure
bb deploy
```

but if you'd like to test the jar locally you can build it with :

``` clojure
bb build-uberjar
java -jar target/production/sasu-caumond-1.0.jar
```

But if you can also call the command below:

``` clojure
bb env-production
```

### Browser Setup

Browser caching should be disabled when developer tools are open to prevent interference with
[`shadow-cljs`](https://github.com/thheller/shadow-cljs) hot reloading.

Custom formatters must be enabled in the browser before
[CLJS DevTools](https://github.com/binaryage/cljs-devtools) can display ClojureScript data in the
console in a more readable way.

#### Chrome/Chromium

1. Open [DevTools](https://developers.google.com/web/tools/chrome-devtools/) (Linux/Windows: `F12`
or `Ctrl-Shift-I`; macOS: `⌘-Option-I`)
2. Open DevTools Settings (Linux/Windows: `?` or `F1`; macOS: `?` or `Fn+F1`)
3. Select `Preferences` in the navigation menu on the left, if it is not already selected
4. Under the `Network` heading, enable the `Disable cache (while DevTools is open)` option
5. Under the `Console` heading, enable the `Enable custom formatters` option

#### Firefox

1. Open [Developer Tools](https://developer.mozilla.org/en-US/docs/Tools) (Linux/Windows: `F12` or
`Ctrl-Shift-I`; macOS: `⌘-Option-I`)
2. Open [Developer Tools Settings](https://developer.mozilla.org/en-US/docs/Tools/Settings)
(Linux/macOS/Windows: `F1`)
3. Under the `Advanced settings` heading, enable the `Disable HTTP Cache (when toolbox is open)`
option

Unfortunately, Firefox does not yet support custom formatters in their devtools. For updates, follow
the enhancement request in their bug tracker:
[1262914 - Add support for Custom Formatters in devtools](https://bugzilla.mozilla.org/show_bug.cgi?id=1262914).

## Update dependencies

For clojure deps, you can run 

``` clojure
bb deps ;; For clojure deps and npm
```

Check regularly and manually w3.css for [updates](https://www.w3schools.com/w3css/w3css_downloads.asp) for newer w3 versions.


## TODO

The next features missing are:

* Add top anchor
* Add npm, git, clj presence in the doctor
* Add training I was teacher of
* Add blogs
* Add SASU mission
