# cerberus-app



## Project setup
```
npm install
```

## AWS-CLI setup

Before developing with AWS Amplify, follow the guide at the link below to install AWS CLI:
```
https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-welcome.html
```

After installing aws/cli run the following command and setup the correct credentails to aws.

```
aws configure
```

## Amplify setup


Start by initializing the project with the following command
```
amplify init
```

And

```
amplify push auth

```


If your CLI cannot find the amplify command, then it means that it isnt installed correctly, start with installing Amplify CLI and then run init once more (may need sudo to complete)

```
npm install -g @aws-amplify/cli
```



## Setup local environment variables
create ```.env.local``` in project folder
```
#In .env.local file
VUE_APP_COGNITO_USERPOOL_ID=your_userpool_ID
VUE_APP_COGNITO_APP_DOMAIN=your_app_domain
VUE_APP_COGNITO_CLIENT_ID=your_client_ID

```


### Compiles and hot-reloads for development
```
npm run serve
```


### Compiles and minifies for production
```
npm run build
```


### Lints and fixes files
```
npm run lint
```


## Testing

### CI

(CI - BitBucket)


### Unit Tests

(Unit Testing - Mocha)


### Code Standard and Linters

The code standard is a combination of the default settings for Vue, JS and
SASS in ESLint and Stylelint as well as custom rules.


### Git Hooks

By running `npm install` a pre-commit Git Hook is installed. This hook runs
ESLint and Stylelint before each commit. It asserts that the code standard is
upheld for all `.vue`, `.js` and `.scss` files.

If a linter check fails the commit is cancelled and the user is requested to
fix the listed files, either with the `-lint-fix` scripts or manually before
performing another commit.



## Folder and File Structure

The application is based in the `/src/` folder.


### Assets

All static assets reside in the `src/assets` folder. Audio files are placed in
`src/assets/audio`. Video files are placed in `src/assets/video`. Image files
are placed in `src/assets/img`.


### Vue Components

All Vue Components are placed as flat `.vue` files in `/src/components/`. As
all logic and styling is separated into other folders the Vue-components reside
as flat files within this folder.


### JavaScript Classes and Modules

All JavaScript files reside within the `/src/js/` folder.

All JavaScript Classes are placed inside individual class-folders inside
`/src/js/class/`. An Example-class would be located in:
`/src/js/class/Example/Example.js`.

All JavaScript Modules are placed inside individual module-folders inside
`/src/js/module/`. An Example-module would be located in:
`/src/js/module/Example/Example.js`.


### Styling, CSS and SASS

All files related to styling are placed in the `/src/css/` folder.

All styling is imported into the `/src/css/style.scss` file. This file is
utlimately compiled to `/src/css/style.min.css` which will be used in the
application.

General application styling such as background colors and typography is placed
inside the `/src/css/general` folder.

Each components styling is contained within a component-specific folder, e.g
`/src/css/Component1/`. If the components styling is split into several files,
make sure the main style file (the one that contains all imports) is named the
same as the folder. This is so that all imports into `style.scss` looks like
```
@import "./Component1/Component1.scss";
```


### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
