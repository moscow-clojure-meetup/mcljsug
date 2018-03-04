(ns mcljsug.components.app
  (:require [re-frame.core :as re-frame]
            [mcljsug.subs :as subs]
            [mcljsug.components.bootstrap :as bp]))


;; home
(defn home-page []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div (str "Hello from " @name ".")
     [:div [:a {:href "/about"} "go to About Page"]]]))


;; about
(defn about-page []
  [:div "This is the About Page."
   [:div [:a {:href "/"} "go to Home Page"]]])


;; main
(defn- pages [page-name]
  (case page-name
    :home-page [home-page]
    :about-page [about-page]
    [:div]))

(defn show-page [page-name]
  [pages page-name])

(defn main-panel []
  (let [current-page (re-frame/subscribe [::subs/current-page])]
    [show-page @current-page]))
