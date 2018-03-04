(ns mcljsug.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [mcljsug.events :as events]
              [mcljsug.routes :as routes]
              [mcljsug.components.app :as app]
              [mcljsug.config :as config]))

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [app/main-panel]
                  (.getElementById js/document "app")))

(defn init! []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))

(init!)

(defn on-js-reload []
  (mount-root))
