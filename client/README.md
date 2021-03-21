# Resource Booking Client



## Project setup
```
npm install
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


### Available routes


```
List all resources

http://localhost:8081/resources

Add new resources

http://localhost:8081/add

Book resources

http://localhost:8081/book

```




## Testing

### Unit Tests

(Unit Testing - Mocha)


### Code Standard and Linters

The code standard is a combination of the default settings for Vue, JS and
SASS in ESLint and Stylelint as well as custom rules.


## Folder and File Structure

The application is based in the `/src/` folder.


### Assets

All static assets reside in the `src/assets` folder. Image files
are placed in `src/assets/img`.


### Vue Components

All Vue Components are placed as flat `.vue` files in `/src/components/`. As
all logic and styling is separated into other folders the Vue-components reside
as flat files within this folder.


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
