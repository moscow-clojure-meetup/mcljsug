(ns mcljsug.components.bootstrap
  (:require [cljsjs.react-bootstrap]
            [reagent.core :refer [adapt-react-class]]))

(def button (adapt-react-class js/ReactBootstrap.Button))
