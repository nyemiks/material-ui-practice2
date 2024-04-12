(ns muiapp.components.theme
  (:require ["@mui/material" :refer [createTheme]])
  )




(def theme-props 
  (clj->js {
                      :components {
                                   :MuiTypography {
                                                   :variants [
                                                               {
                                                                :props {
                                                                        :variant "body2"
                                                                       }
                                                                :style {
                                                                        :fontSize 11
                                                                       
                                                                       }
                                                                }
                                                                {
                                                                :props {
                                                                        :variant "body3"
                                                                       }
                                                                :style {
                                                                        :fontSize 9
                                                                       }
                                                                }
                                                              ]
                                   }
                                   }
                     })
  )


;theme-props


(def custom-theme (createTheme theme-props))

;custom-theme2

(def custom-theme2 (createTheme (clj->js {})))

(def btn-theme-props (clj->js {
                               :components {
                                            :MuiButtonBase {
                                                            :defaultProps {
                                                                           :disableRipple true
                                                                          }
                                                           }
                                           }
                               }
                              )
  )


(def button-theme (createTheme btn-theme-props))

;; override style
(def btn-theme-props-2 (clj->js {
                                 :components 
                                            {
                                              :MuiButton {
                                                          :styleOverrides {
                                                                           :root {
                                                                                    :fontSize "5rem"
                                                                                  }
                                                                          }
                                              }
                                            }
                                 }
                                )
  )


(def button-theme-2 (createTheme btn-theme-props-2))
