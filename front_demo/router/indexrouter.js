const express = require('express');
const router = express.Router();
const path = require('path');

router.use('/css', express.static(path.join(__dirname, '../css')));
router.use('/img', express.static(path.join(__dirname, '../img')));
router.use('/js', express.static(path.join(__dirname, '../js')));

router.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '../view', 'homepage.html'))
});

router.get('/login', (req, res) => {
    res.sendFile(path.join(__dirname, '../view', 'login.html'))
});

router.get('/signup', (req, res) => {
    res.sendFile(path.join(__dirname, '../view', 'signup.html'))
});

module.exports = router;

